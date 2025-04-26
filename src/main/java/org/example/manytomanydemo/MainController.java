package org.example.manytomanydemo;

import lombok.RequiredArgsConstructor;
import org.example.manytomanydemo.service.MeetingService;
import org.example.manytomanydemo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final PersonService personService;
    private final MeetingService meetingService;

    @GetMapping("/people")
    public String people(Model model) {
        model.addAttribute("people", personService.findAll());
        return "people";
    }
}

