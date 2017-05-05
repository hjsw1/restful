package test.swagger.may;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author may
 * @version Revision 1.0.0
 * @CreateTime 2017年3月30日 上午11:27:14
 */
public class Person
{
	@ApiModelProperty(value = "姓名", required = true)
	private String name;
	@ApiModelProperty(value = "年龄", required = true)
	private int age;

	// private List<Map<String, String>> persons;

	// private Map<String, String> map;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}
