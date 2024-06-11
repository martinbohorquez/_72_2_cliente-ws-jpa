package org.mbohorquez.cliente.ws;

import org.mbohorquez.webapp.jaxws.services.Curso;
import org.mbohorquez.webapp.jaxws.services.CursoServiceWs;
import org.mbohorquez.webapp.jaxws.services.CursoServiceWsImplService;

public class Main {
    public static void main(String[] args) {
        CursoServiceWs service = new CursoServiceWsImplService().getCursoServiceWsImplPort();

        Curso curso = new Curso();
        curso.setNombre("React v18");
        curso.setDescripcion("Framework de JavaScript para construir interfaces de usuario interactivas.");
        curso.setDuracion(50D);
        curso.setInstructor("Martin Bohorquez");
        Curso respuesta = service.guardar(curso);
        System.out.println("nuevo curso: " + respuesta.getId() + ", " + respuesta.getNombre());

        service.listar().forEach(c -> System.out.println(c.getNombre()));

    }
}
