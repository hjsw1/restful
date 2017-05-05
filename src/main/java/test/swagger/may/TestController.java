package test.swagger.may;

/**
 * @author may
 * @version Revision 1.0.0
 * @CreateTime 2017年3月30日  上午11:32:52
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

 *	你可以把这地址分开理解，其中问号前半部分：http://localhost:8080/Springmvc/user/page.do 这个就是路径，是你的请求url，而如果这个路径上有数据匹配，用的就是@PathVariable  如 
 *	@RequestMapping(value="/page{pageNo}.do") 
 *	public String page(@PathVariable int pageNo){} 
 *	【注意：看下这地方的@RequestMapping的地址，对照我上面说的路径】 
 *
 *	而问号的后面部分就是请求参数部分，是要向请求路径提交的参数信息，用的就是@RequestParam ，对于这种参数，如果你要用的话，代码应该如下： 
 *	@RequestMapping(value="/page.do") 
 *	public String page(@RequestParam int pageSize,@RequestParam  int pageNow){} 
 *
 * 【注意：这个代码的RequestMapping地址只需要/page.do就行】 
 *
 * 其实你只要把什么叫请求路径，什么叫请求参数分清楚，也就能理解@PathVariable和@RequestParam 
 * http://www.iteye.com/problems/101566 这个如果对应sprimgmvc里面，想获取问题编号101566，
 * 因为这个地址直接就是请求路径，是一个url，所以代码中用的应该是@PathVariable，如下： 
 * @RequestMapping(value="/problems/{problemId}") 
 * public String showProblem(@PathVariable int problemId){}
 *
 * @requestParam 是请求参数
 * @PathVariable 是请求路径
 */
@Controller
@RequestMapping("/mvc")
public class TestController
{
	private Logger logger = Logger.getLogger(TestController.class);

	/**
	 * 如果传入的参数为2个对象类型，那么method只能使用post请求的方式
	 * 
	 * @param student
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据用户名获取用户对象", httpMethod = "POST", response = ModelMap.class, notes = "根据用户名获取用户对象")
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
	 * 如果传入的参数为2个对象类型，那么method只能使用post请求的方式
	 * 
	 * @param student
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/user1", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据用户名获取用户对象", httpMethod = "POST", response = ModelMap.class, notes = "根据用户名获取用户对象")
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
	 * 只能使用post请求的方式
	 * 
	 * @param student
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/user2", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据用户名获取用户对象", httpMethod = "POST", response = ModelMap.class, notes = "根据用户名获取用户对象")
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
	@ApiOperation(value = "根据用户名获取用户对象", httpMethod = "POST", response = ModelMap.class, notes = "根据用户名获取用户对象")
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
	 * 如果传入的参数为基本类型的，那么method为post或者get请求都可以
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取传入的id参数")
	public Integer getId(
			@ApiParam(name = "id", value = "序号", defaultValue = "6", required = true) @RequestParam("id") Integer id)
	{
		return id;
	}

	@RequestMapping(value = "/id1/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取传入的id参数")
	public ModelMap getId1(
			@ApiParam(name = "id", value = "序号1", defaultValue = "8", required = true) @PathVariable("id") Integer id)
	{
		ModelMap map = new ModelMap();
		map.addAttribute("id", id);
		return map;
		// return id;
	}

	/**
	 * 如果传入的参数有基本类型和对象类型的，那么method为post或者get请求都可以
	 * 
	 * @param id
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "返回modelandview数据")
	public ModelMap getPersonAndId(
			@ApiParam(name = "id", value = "序号", defaultValue = "11", required = true) @PathVariable("id") Integer id,
			@ModelAttribute("person") Person person)
	{
		ModelMap map = new ModelMap();
		map.addAttribute("id", id);
		return map;
	}

	@RequestMapping(value = "/person2/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "返回modelandview数据")
	public ModelMap getPersonAndId2(
			@ApiParam(name = "id", value = "序号", defaultValue = "11", required = true) @PathVariable("id") Integer id,
			@ModelAttribute("person") Person person)
	{
		ModelMap map = new ModelMap();
		map.addAttribute("id", id);
		return map;
	}

	@RequestMapping(value = "/person1/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "返回modelandview数据")
	public ModelMap getPersonAndId1(
			@ApiParam(name = "id", value = "序号", defaultValue = "12", required = true) @PathVariable("id") Integer id,
			@ModelAttribute("person") Person person)
	{
		ModelMap map = new ModelMap();
		map.addAttribute("id", id);
		return map;
	}

}
