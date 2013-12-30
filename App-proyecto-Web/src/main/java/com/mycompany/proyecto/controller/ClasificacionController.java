package com.mycompany.proyecto.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.proyecto.model.Clasificacion;
import com.mycompany.proyecto.service.ClasificacionService;

/**
 * Handles requests for the application home page.
 * Anotando una clase Java como @Controller se convierte en un controlador, 
 * es decir, en una clase encargada de recibir las peticiones HttpServletRequest.
 * 
 * El objeto Model simplemente es un mapa donde guardaremos los objetos 
 * que queremos pasar a la vista (es la M de MVC)
 * 
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */

/**
 * Principal componente do framework <code>Spring MVC</code>, esse é o controller do cadastro de mercadorias. 
 * 
 * <p>Tem como responsabilidade: definir o mapeamento de navegação, acionar validadores e conversores de dados, 
 * fornecer e receber os dados da camada de visão (<code>JSP</code>).</p>
 * 
 * <p>Os métodos de navegação, retornam a url definida no Tiles. Veja também o arquivo <code>views.xml</code>.</p>
 * 
 * @author Rodrigo Garcete
 */
@RequestMapping(value="/clasificacion")
@Controller
public class ClasificacionController {
	
	//private static final Logger log = LoggerFactory.getLogger(DepositoController.class);
	
	public static final int DEFAULT_CLASIFICACION_POR_PAGINA = 25;

	private final ClasificacionService clasificacionService;
	
	@Autowired
	public ClasificacionController(ClasificacionService is){
		this.clasificacionService = is;
	}
	 
	/**
	 * Punto de entrada del controlador
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(value="/listado",method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("clasificaciones", clasificacionService.getAll());
		return "listaClasificaciones";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		uiModel.addAttribute("clasificacion", new Clasificacion());
		//uiModel.addAttribute("active", "incluir");
		return "incluirClasificacion";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String crear(@Valid Clasificacion c, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("clasificacion", c);
            return "incluirCiudad";
        }
		
		this.clasificacionService.save(c);
		return "redirect:/clasificacion/listado";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		Clasificacion c = clasificacionService.findById(id);
		if (c != null) {
			uiModel.addAttribute("clasificacion", c);
		}
		return "editarClasificacion";
	}
	
	/**
	 * Método ejecutado al actualizar
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String editar(@Valid Clasificacion c, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("clasificacion", c);
            return "editarClasificacion"; 
        }
		this.clasificacionService.save(c);
		return "redirect:/clasificacion/listado";
	}
	
	/**
	 * Método ejecutado para eliminacion
	 * @param id de la clasificacion que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		Clasificacion m = clasificacionService.findById(id);
		if (m != null) {
			this.clasificacionService.remove(m); 
		}
		return "redirect:/clasificacion/listado";
    }
	
}