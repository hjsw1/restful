package test.swagger.may;

/**
 * @author may
 * @version Revision 1.0.0
 * @CreateTime 2017��3��30��  ����11:32:52
 */
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 *	http://localhost:8080/Springmvc/user/page.do?pageSize=3&pageNow=2 

 *	����԰����ַ�ֿ���⣬�����ʺ�ǰ�벿�֣�http://localhost:8080/Springmvc/user/page.do �������·�������������url����������·����������ƥ�䣬�õľ���@PathVariable  �� 
 *	@RequestMapping(value="/page{pageNo}.do") 
 *	public String page(@PathVariable int pageNo){} 
 *	��ע�⣺������ط���@RequestMapping�ĵ�ַ������������˵��·���� 
 *
 *	���ʺŵĺ��沿�־�������������֣���Ҫ������·���ύ�Ĳ�����Ϣ���õľ���@RequestParam ���������ֲ����������Ҫ�õĻ�������Ӧ�����£� 
 *	@RequestMapping(value="/page.do") 
 *	public String page(@RequestParam int pageSize,@RequestParam  int pageNow){} 
 *
 * ��ע�⣺��������RequestMapping��ַֻ��Ҫ/page.do���С� 
 *
 * ��ʵ��ֻҪ��ʲô������·����ʲô����������������Ҳ�������@PathVariable��@RequestParam 
 * http://www.iteye.com/problems/101566 ��������Ӧsprimgmvc���棬���ȡ������101566��
 * ��Ϊ�����ֱַ�Ӿ�������·������һ��url�����Դ������õ�Ӧ����@PathVariable�����£� 
 * @RequestMapping(value="/problems/{problemId}") 
 * public String showProblem(@PathVariable int problemId){}
 *
 * @requestParam ���������
 * @PathVariable ������·��
 */
@Controller
@RequestMapping("/mvc")
public class TestController
{
	private Logger logger = Logger.getLogger(TestController.class);

	/**
	 * �������Ĳ���Ϊ2���������ͣ���ômethodֻ��ʹ��post����ķ�ʽ
	 * 
	 * @param student
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "�����û�����ȡ�û�����", httpMethod = "POST", response = ModelMap.class, notes = "�����û�����ȡ�û�����")
	public ModelMap get(@ModelAttribute("student") Student student, @ModelAttribute("person") Person person)
	{
		logger.info("name:" + person.getName());
		logger.info("age:" + person.getAge());
		ModelMap map = new ModelMap();
		map.addAttribute("name", person.getName());
		map.addAttribute("age", person.getAge());
		map.addAttribute("stuName", student.getStuName());
		map.addAttribute("stuAge", student.getStuAge());
		map.addAttribute("result", "ok");
		return map;
	}

	/**
	 * �������Ĳ���Ϊ2���������ͣ���ômethodֻ��ʹ��post����ķ�ʽ
	 * 
	 * @param student
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/user1", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "�����û�����ȡ�û�����", httpMethod = "POST", response = ModelMap.class, notes = "�����û�����ȡ�û�����")
	public ModelMap get1(@ModelAttribute("student") Student student, @RequestBody Person person)
	{
		logger.info("name:" + person.getName());
		logger.info("age:" + person.getAge());
		ModelMap map = new ModelMap();
		map.addAttribute("name", person.getName());
		map.addAttribute("age", person.getAge());
		map.addAttribute("stuName", student.getStuName());
		map.addAttribute("stuAge", student.getStuAge());
		map.addAttribute("result", "ok");
		return map;
	}

	/**
	 * ֻ��ʹ��post����ķ�ʽ
	 * 
	 * @param student
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/user2", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "�����û�����ȡ�û�����", httpMethod = "POST", response = ModelMap.class, notes = "�����û�����ȡ�û�����")
	public ModelMap get2(@RequestBody Student student, @ModelAttribute("person") Person person)
	{
		logger.info("name:" + person.getName());
		logger.info("age:" + person.getAge());
		ModelMap map = new ModelMap();
		map.addAttribute("name", person.getName());
		map.addAttribute("age", person.getAge());
		map.addAttribute("stuName", student.getStuName());
		map.addAttribute("stuAge", student.getStuAge());
		map.addAttribute("result", "ok");
		return map;
	}

	@RequestMapping(value = "/user3", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "�����û�����ȡ�û�����", httpMethod = "POST", response = ModelMap.class, notes = "�����û�����ȡ�û�����")
	public ModelMap get3(@ModelAttribute("student") Student student, @ModelAttribute("person") Person person)
	{
		logger.info("name:" + person.getName());
		logger.info("age:" + person.getAge());
		ModelMap map = new ModelMap();
		map.addAttribute("name", person.getName());
		map.addAttribute("age", person.getAge());
		map.addAttribute("stuName", student.getStuName());
		map.addAttribute("stuAge", student.getStuAge());
		map.addAttribute("result", "ok");
		return map;
	}

	/**
	 * �������Ĳ���Ϊ�������͵ģ���ômethodΪpost����get���󶼿���
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "��ȡ�����id����")
	public Integer getId(
			@ApiParam(name = "id", value = "���", defaultValue = "6", required = true) @RequestParam("id") Integer id)
	{
		return id;
	}

	@RequestMapping(value = "/id1/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "��ȡ�����id����")
	public ModelMap getId1(
			@ApiParam(name = "id", value = "���1", defaultValue = "8", required = true) @PathVariable("id") Integer id)
	{
		ModelMap map = new ModelMap();
		map.addAttribute("id", id);
		return map;
		// return id;
	}

	/**
	 * �������Ĳ����л������ͺͶ������͵ģ���ômethodΪpost����get���󶼿���
	 * 
	 * @param id
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "����modelandview����")
	public ModelMap getPersonAndId(
			@ApiParam(name = "id", value = "���", defaultValue = "11", required = true) @PathVariable("id") Integer id,
			@ModelAttribute("person") Person person)
	{
		ModelMap map = new ModelMap();
		map.addAttribute("id", id);
		return map;
	}

	@RequestMapping(value = "/person2/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "����modelandview����")
	public ModelMap getPersonAndId2(
			@ApiParam(name = "id", value = "���", defaultValue = "11", required = true) @PathVariable("id") Integer id,
			@ModelAttribute("person") Person person)
	{
		ModelMap map = new ModelMap();
		map.addAttribute("id", id);
		return map;
	}

	@RequestMapping(value = "/person1/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "����modelandview����")
	public ModelMap getPersonAndId1(
			@ApiParam(name = "id", value = "���", defaultValue = "12", required = true) @PathVariable("id") Integer id,
			@ModelAttribute("person") Person person)
	{
		ModelMap map = new ModelMap();
		map.addAttribute("id", id);
		return map;
	}

}
