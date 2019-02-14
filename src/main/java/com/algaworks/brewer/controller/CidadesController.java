package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cidade;

@Controller
public class CidadesController {
	
	@RequestMapping("/cidades/nova")
	public String nova(Cidade cidade){
		return "cidade/CadastroCidade";
	}
	
	@RequestMapping(value="cidade/CadastroCidade", method = RequestMethod.POST)
	public String cadastrar(@Valid Cidade cidade,BindingResult result, Model model, RedirectAttributes attibutes){
		if(result.hasErrors()){
			return nova(cidade);
		}
		return "redirect:/cidades/nova";
	}

}
