package com.tutorbooking.controller;

import com.tutorbooking.model.User;
import com.tutorbooking.model.Student;
import com.tutorbooking.model.Tutor;
import com.tutorbooking.service.UserService;
import com.tutorbooking.service.TutorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService = new UserService();
    private final TutorService tutorService = new TutorService();

    @GetMapping("/profile")
    public String viewProfile(HttpSession session, Model model) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser == null)
            return "redirect:/login";
        model.addAttribute("user", loggedUser);
        return "user/profile";
    }

    @PostMapping("/update")
    public String updateProfile(HttpSession session, @RequestParam String name,
            @RequestParam(required = false) String grade,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) Double rate) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser == null)
            return "redirect:/login";

        User updatedUser;
        if (loggedUser instanceof Student) {
            updatedUser = new Student(loggedUser.getId(), name, loggedUser.getEmail(),
                    loggedUser.getPassword(), grade);
        } else {
            // Tutor: Preserve all existing fields
            Tutor existingTutor = (Tutor) loggedUser;
            updatedUser = new Tutor(existingTutor.getId(), name, existingTutor.getEmail(),
                    existingTutor.getPassword(), existingTutor.getPhone(),
                    subject, existingTutor.getExperience(), rate,
                    existingTutor.getRating());
            // Also update in TutorRepository (tutors.txt)
            tutorService.updateTutor(loggedUser.getId(), (Tutor) updatedUser);
        }

        userService.updateUser(loggedUser.getId(), updatedUser);
        session.setAttribute("loggedUser", updatedUser); // Update session
        return "redirect:/users/profile?updated=true";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id, HttpSession session) {
        userService.deleteUser(id);
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser != null && loggedUser.getId().equals(id)) {
            session.invalidate();
            return "redirect:/login";
        }
        return "redirect:/users/list";
    }
}
