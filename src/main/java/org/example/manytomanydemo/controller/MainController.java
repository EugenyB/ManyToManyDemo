package org.example.manytomanydemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.manytomanydemo.data.Meeting;
import org.example.manytomanydemo.service.MeetingService;
import org.example.manytomanydemo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/meetings")
    public String meetings(Model model) {
        model.addAttribute("meetings", meetingService.findAll());
        return "meetings";
    }

    @GetMapping("/meeting/by_person")
    public String meetingsByPerson(@RequestParam Integer id, Model model) {
        List<Meeting> meetings = new ArrayList<>(personService.findMeetings(id));
        List<Meeting> available = personService.findAvailableMeetings(id);
        model.addAttribute("meetings", meetings);
        model.addAttribute("available", available);
        model.addAttribute("person", personService.findById(id).get());
        return "meetings_by_person";
    }

    @GetMapping("/people/meeting/add/{pid}/{mid}")
    public String addMeetingForPerson(@PathVariable Integer pid, @PathVariable Integer mid) {
        personService.addMeeting(pid, mid);
        return "redirect:/meeting/by_person?id=" + pid;
    }

    @GetMapping("/people/meeting/remove/{pid}/{mid}")
    public String removeMeetingForPerson(@PathVariable Integer pid, @PathVariable Integer mid) {
        personService.removeMeeting(pid, mid);
        return "redirect:/meeting/by_person?id=" + pid;
    }

}

