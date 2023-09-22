package com.controlle.notebooks.Controller;

import com.controlle.notebooks.Service.S_Notebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_notebooks {
    @GetMapping("/cadastro/Notebook")
    public String getCadastro(){
        return "Notebook/cadastro";
    }

    @PostMapping("/cadastro/Notebook")
    @ResponseBody
    public String cadastrarNotebook(@RequestParam("numero") String numero,
                                   @RequestParam("patrimonio") String patrimonio){
                                   S_Notebook.cadastrarNotebook(numero,patrimonio);
        return "Notebook/cadastro";
    }
}

