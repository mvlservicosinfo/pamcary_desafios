package br.com.dominio.cpfweb.Controller;


import br.com.dominio.cpfweb.Model.ModelCPF;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ControllerCPF {

@RequestMapping(value = "/CPF", method=RequestMethod.GET)
public ModelAndView cpf(){
    return new ModelAndView("modelCPF", "command", new ModelCPF());
}

//Gravo banco o dados do CPF
@RequestMapping(value = "/addCPF", method = RequestMethod.POST)
public String GravarCPF(@ModelAttribute("SpringWEB") ModelCPF modelCPF, ModelMap model, HttpServletRequest request){
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");

        model.addAttribute("token", modelCPF.getToken());
        model.addAttribute("cpf",modelCPF.getCPF());
        model.addAttribute("data_nascimento", modelCPF.getData_nascimento());
        model.addAttribute("plugin",modelCPF.getPlugin());

        List<ModelCPF> modelcpfs = (List<ModelCPF>) request.getSession().getAttribute("modelcpfs");
         if(modelcpfs == null){
             modelcpfs = new ArrayList<ModelCPF>();
         }
         modelcpfs.add(modelCPF);
         request.getSession().setAttribute("ModelCPF", modelcpfs);
        return "Exibe CPF";
    }


}
