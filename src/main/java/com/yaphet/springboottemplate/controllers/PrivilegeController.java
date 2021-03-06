package com.yaphet.springboottemplate.controllers;

import com.yaphet.springboottemplate.models.Privilege;
import com.yaphet.springboottemplate.services.PrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("privilege")
@PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
public class PrivilegeController {
    private final PrivilegeService privilegeService;

    @GetMapping
    public String privilegeList(Model model){
        List<Privilege> privilegeList = privilegeService.getAllPrivileges();
        model.addAttribute("privilegeList", privilegeList);
        return "privilege/privilege-list";
    }


}
