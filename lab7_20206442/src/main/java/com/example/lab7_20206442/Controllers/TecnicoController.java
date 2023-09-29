package com.example.lab7_20206442.Controllers;

import com.example.lab7_20206442.Entity.Tecnico;
import com.example.lab7_20206442.Repository.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    TecnicoRepository tecnicoRepository;


    @GetMapping(value = {"","/list"})
    public String principal(Model model){
        model.addAttribute("listaTecnicos",tecnicoRepository.findAll());
        return "tecnico/principal";
    }

    @GetMapping("/new")
    public String nuevoTecnico(Model model, @ModelAttribute("tecnico")Tecnico tecnico){

        return "tecnico/edit";
    }

    @GetMapping("/edit")
    public String editarTecnico(Model model, @ModelAttribute("tecnico") Tecnico tecnico,
                                @RequestParam("id") Integer id){

        Optional<Tecnico > optionalTecnico = tecnicoRepository.findById(id);

        if (optionalTecnico.isPresent()){
            tecnico = optionalTecnico.get();
            model.addAttribute("tecnico", tecnico);
            return "tecnico/edit";
        }else {
            return "redirect:/tecnico";
        }

    }

    @GetMapping("/delete")
    public String borrarTecnico(@RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Tecnico> optionalTecnico = tecnicoRepository.findById(id);

        if (optionalTecnico.isPresent()) {
            tecnicoRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Producto borrado exitosamente");
        }
        return "redirect:/tecnico";

    }

    @PostMapping("/save")
    public String guardarTecnico(RedirectAttributes attributes, Model model,
                                 @ModelAttribute("tecnico") @Valid Tecnico tecnico, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "tecnico/edit";
        }else{
            System.out.println(tecnico.getTechnicianID());
            if (tecnico.getTechnicianID() == null){
                attributes.addFlashAttribute("msg","Tecnico " + tecnico.getFirstName() +" "+ tecnico.getLastName()+" "+ " actualizado exitosamente");
            }else {
                attributes.addFlashAttribute("msg","Tecnico " + tecnico.getFirstName() +" "+ tecnico.getLastName()+" "+ " actualizado exitosamente");
            }
            tecnicoRepository.save(tecnico);
            return "redirect:/tecnico";
        }
    }
}
