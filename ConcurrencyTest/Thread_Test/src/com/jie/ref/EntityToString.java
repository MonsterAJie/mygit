package com.jie.ref;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class EntityToString {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Code code = new Code();
		code.setPrice("1");
		EntityToString.getString(code,Code.class);
	}
//	@Test
//	public String toString(){
//		return 
//	}
	/**
	 * @MethodName : getString
	 * @Description : 获取类中所有属性及属性值
	 * @param o
	 *            操作对象
	 * @param c
	 *            操作类，用于获取类中的方法
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static String getString(Object o, Class< ? > c ) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
	{
		String result = c.getSimpleName( ) + ":";
		Object h = o;
		Field field1 = h.getClass().getDeclaredField("price");
//		t.getClass().getDeclaredField("price").set(String.class, "1");
		// 获取父类，判断是否为实体类
		if ( c.getSuperclass( ).getName( ).indexOf( "entity" ) >= 0 )
		{
			result +="\n<" +getString( o , c.getSuperclass( ) )+">,\n";
		}
 
		// 获取类中的所有定义字段
		Field[ ] fields = c.getDeclaredFields( );
 
		// 循环遍历字段，获取字段对应的属性值
		for ( Field field : fields )
		{
			// 如果不为空，设置可见性，然后返回
			field.setAccessible( true );
 
			try
			{
				// 设置字段可见，即可用get方法获取属性值。
				result += field.getName( ) + "=" + field.get( o ) +",\n";
			}
			catch ( Exception e )
			{
				// System.out.println("error--------"+methodName+".Reason is:"+e.getMessage());
			}
		}
		if(result.indexOf( "," )>=0) result = result.substring( 0 , result.length( )-2 );
		return result;
	}
}
