package egovframework.mybatisTest.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.mybatisTest.service.MybatisTestService;
import egovframework.mybatisTest.service.MybatisTestVO;

@Controller
public class MybatisTestController {
	
	/** MybatisTestService */
    @Resource(name = "mybatisTestService")
    private MybatisTestService mybatisTestService;
	
	@RequestMapping(value="/mybatisTest/mybatisTest.do")
	public String mybatisTest(@ModelAttribute("searchVO") MybatisTestVO searchVO,
			ModelMap model)
			throws Exception {
		
		List<MybatisTestVO> mybatisList = mybatisTestService.mybatisTest(searchVO);
		model.addAttribute("mybatisList", mybatisList);
	
		return "/mybatisTest/mybatisTest";
	}
	
}
