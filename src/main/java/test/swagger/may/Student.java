package test.swagger.may;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author may
 * @version Revision 1.0.0
 * @CreateTime 2017��3��30�� ����11:27:34
 */
public class Student
{
	@ApiModelProperty(value = "ѧ������", required = true)
	private String stuName;
	@ApiModelProperty(value = "ѧ������", required = true)
	private Integer stuAge;

	public String getStuName()
	{
		return stuName;
	}

	public void setStuName(String stuName)
	{
		this.stuName = stuName;
	}

	public Integer getStuAge()
	{
		return stuAge;
	}

	public void setStuAge(Integer stuAge)
	{
		this.stuAge = stuAge;
	}

}
