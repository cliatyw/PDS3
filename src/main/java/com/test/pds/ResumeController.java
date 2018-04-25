/*[김도희]*/
package com.test.pds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.resume.service.ResumeRequest;
import com.test.pds.resume.service.ResumeService;

@Controller
public class ResumeController {

	@Autowired
	private ResumeService resumeService;
	
	@RequestMapping(value = "/insertResume", method = RequestMethod.GET)
	public String insertResume() {
		return "/resume/insertResume";
	}
	
	@RequestMapping(value = "/insertResume", method = RequestMethod.POST)
	public String insertResume(ResumeRequest resumeRequest) {
		resumeService.insertResume(resumeRequest);
		return "redirect:/insertResume";
	}
	
}
