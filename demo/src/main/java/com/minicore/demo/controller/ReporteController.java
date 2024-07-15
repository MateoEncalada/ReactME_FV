package com.minicore.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minicore.demo.dto.TareaDto;
import com.minicore.demo.service.TareaService;

@RestController
public class ReporteController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/api/tareas/reporte")
    public List<TareaDto> generarReporte(@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
                                         @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        return tareaService.obtenerTareasPasadasEnProgreso(fechaInicio, fechaFin);
    }
}





// package com.minicore.demo.controller;

// import java.util.Date;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.minicore.demo.dto.TareaDto;
// import com.minicore.demo.service.TareaService;

// @Controller
// public class ReporteController {

//     @Autowired
//     private TareaService tareaService;

//     @GetMapping("/")
//     public String mostrarFormulario() {
//         return "index";
//     }

//     @GetMapping("/reporte")
//     public String generarReporte(@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
//                                  @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
//                                  Model model) {
//         List<TareaDto> tareas = tareaService.obtenerTareasPasadasEnProgreso(fechaInicio, fechaFin);
//         model.addAttribute("tareas", tareas);
//         model.addAttribute("fechaFin", fechaFin);
//         return "reporte";
//     }
// }




