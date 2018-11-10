<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table class="easyui-datagrid" id="itemList" title="商品列表"
       data-options="singleSelect:false,
				       collapsible:true,
				       url:'/item/list',
				       method:'get',
				       pagination:true,
				       pageSize:30,
				       toolbar:'#tb'">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">商品ID</th>
            <th data-options="field:'title',width:200">商品标题</th>
            <th data-options="field:'cid',width:100">叶子类目</th>
            <th data-options="field:'sellPoint',width:100">卖点</th>
            <th data-options="field:'price',width:70,align:'right',formatter:TAOTAO.formatPrice">价格</th>
            <th data-options="field:'num',width:70,align:'right'">库存数量</th>
            <th data-options="field:'barcode',width:100">条形码</th>
            <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<div id = "tb">
	商品标题<input type="text" id="itemName"/>
	商品卖点<input type="text" id="itemSale"/>
	商品价格区间<input class="easyui-combobox" id="price" editable="false" name="price" data-options="url:'/code/price?name=price',method:'get',valueField:'price',textField:'price',panelHeight:'auto'" style="width:180px" />
	<a href="#" class="easyui-linkbutton" onclick='scbt()'iconCls="icon-search">搜索</a><br/>
	<a href="#" class="easyui-linkbutton" onclick='addbt()' iconCls="icon-add">新增</a>
	<a href="#" class="easyui-linkbutton" onclick='editbt()' iconCls="icon-edit">编辑</a>
	<a href="#" class="easyui-linkbutton" onclick='deletebt()' iconCls="icon-cancel">删除</a>
	<a href="#" class="easyui-linkbutton" onclick='instockbt()' iconCls="icon-remove">下架</a>
	<a href="#" class="easyui-linkbutton" onclick='reshelfbt()' iconCls="icon-remove">上架</a>
</div>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/item-edit'" style="width:80%;height:80%;padding:10px;">

<script>
	function scbt() {
	    var json = {};
		json.price  = $('#price').combobox("getText");

		var arr = json.price.split("-");
		var sear = new RegExp('-');
		
		if (json.price != "") {
			if(sear.test(json.price) && arr.length == 2){
				
			} else {
				alert("金额格式错误，请修正！");
				$("#price").focus();
				return;
			}

			for (var i = 0; i < arr.length; i ++) {
				if (!$.isNumeric(arr[i])) {
					alert("金额格式错误，请修正！！");
					$("#price").focus();
					return;
				}
			}
		}

	    $('#itemList').datagrid({
	        url:'/item/qbc',
	        queryParams:{
	        	title: encodeURI($("#itemName").val()),
	        	sellPoint: encodeURI($("#itemSale").val()),
	        	price: encodeURI(json.price),
	        }
	    });

	}
    
    function addbt() {
    	$(".tree-title:contains('新增商品')").parent().click();
    }
    
    function editbt() {
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','必须选择一个商品才能编辑!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('提示','只能选择一个商品!');
    		return ;
    	}
    	
    	$("#itemEditWindow").window({
    		onLoad :function(){
    			//回显数据
    			var data = $("#itemList").datagrid("getSelections")[0];
    			data.priceView = TAOTAO.formatPrice(data.price);
    			$("#itemeEditForm").form("load",data);
    			
    			// 加载商品描述
    			$.getJSON('/item/desc/'+data.id,function(_data){
    				if(_data.status == 200){
    					//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
    					itemEditEditor.html(_data.data.itemDesc);
    				}
    			});
    			
    			//加载商品规格
    			$.getJSON('/item/param/'+data.id,function(_data){
    				if(_data && _data.status == 200 && _data.data && _data.data.paramData){
    					$("#itemeEditForm .params").show();
    					$("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
    					$("#itemeEditForm [name=itemParamId]").val(_data.data.id);
    					
    					//回显商品规格
    					 var paramData = JSON.parse(_data.data.paramData);
    					
    					 var html = "<ul>";
    					 for(var i in paramData){
    						 var pd = paramData[i];
    						 html+="<li><table>";
    						 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
    						 
    						 for(var j in pd.params){
    							 var ps = pd.params[j];
    							 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
    						 }
    						 
    						 html+="</li></table>";
    					 }
    					 html+= "</ul>";
    					 $("#itemeEditForm .params td").eq(1).html(html);
    				}
    			});
    			
    			TAOTAO.init({
    				"pics" : data.image,
    				"cid" : data.cid,
    				fun:function(node){
    					TAOTAO.changeItemParam(node, "itemeEditForm");
    				}
    			});
    		}
    	}).window("open");
    }
    
    function deletebt() {
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中商品!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/item/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除商品成功!',undefined,function(){
        					$("#itemList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
    
    function instockbt() {
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中商品!');
    		return ;
    	}
    	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/item/instock",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','下架商品成功!',undefined,function(){
        					$("#itemList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
	
    function reshelfbt() {
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中商品!');
    		return ;
    	}
    	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/item/reshelf",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','上架商品成功!',undefined,function(){
        					$("#itemList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
    
    function getSelectionsIds(){
    	var itemList = $("#itemList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }

</script>