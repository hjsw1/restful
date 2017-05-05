package test.swagger.may;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author may
 * @version Revision 1.0.0
 * @CreateTime 2017年3月30日 上午11:27:34
 */
public class Student
{
	@ApiModelProperty(value = "学生姓名", required = true)
	private String stuName;
	@ApiModelProperty(value = "学生年龄", required = true)
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
