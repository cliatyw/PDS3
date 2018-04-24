package com.test.pds;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.resume.service.ResumeRequest;

@Controller
public class ResumeController {

	@RequestMapping(value = "/addResume", method = RequestMethod.GET)
	public String addResume() {
		return "/resume/addResume";
	}
	
	@RequestMapping(value = "/addResume", method = RequestMethod.POST)
	public String addResume(ResumeRequest resumeRequest) {
		
		return "redirect:/addResume";
	}
	
}
