package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.java.model.Operation;
import com.java.service.OperationService;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.validation.Valid;

@Controller
public class AirthematicOperationController {

    private OperationService service;

    @Autowired
    public AirthematicOperationController(OperationService service) {
        this.service = service;
    }

    @GetMapping
    public String showAllOperations(Model model) {
        model.addAttribute("operations", service.findAll());
        return "operations";
    }

    @GetMapping("/new-operation")
    public String showOperationsCreationForm(Model model) {
        model.addAttribute("operation", new Operation());
        return "new-operation";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewOperations(@Valid @ModelAttribute Operation operation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-operation";
        }
        ScriptEngineManager sc= new ScriptEngineManager();
        ScriptEngine se = sc.getEngineByName("JavaScript");
        Object ob = null;
		try {
			ob = se.eval(operation.getInput());
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			 return "new-operation";
//			e.printStackTrace();
		}
        int operationResule = (int) ob;
        operation.setInput(operation.getInput()+"="+operationResule);
        service.save(operation);
        model.addAttribute("operations", service.findAll());
        return "operations";
    }

    @PostMapping("/{id}/delete")
    public String deleteOperations(@PathVariable Long id, Model model) {
        service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid operation Id:" + id));
        service.deleteById(id);
        model.addAttribute("operations", service.findAll());
        return "operations";
    }
}
