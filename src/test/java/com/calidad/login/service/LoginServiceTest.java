package com.calidad.login.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import com.calidad.login.dao.IDAOLogin;
import com.calidad.login.modelo.Usuario;

public class LoginServiceTest {

    @Test
    void loginExitosoTest() {
        // 1️Datos de prueba
        String email = "alba.cruz@gmail.com";
        String contrasena = "albita142003";

        // 2️ Crear el mock del DAO
        IDAOLogin idaoLogin = mock(IDAOLogin.class);

        // 3️ Crear el usuario que el mock devolverá
        Usuario usuario = new Usuario("Alba Cruz", true, contrasena, email);

        // 4️ Configurar el comportamiento del mock
        when(idaoLogin.findUserByEmail(email)).thenReturn(usuario);

        // 5️ Instanciar la clase que vamos a probar con el mock
        LoginService loginService = new LoginService(idaoLogin);

        // 6️ Ejecutar el método a probar
        boolean resultado = loginService.login(email, contrasena);

        // 7️ Verificar el resultado
        assertThat(resultado, is(true));
    }

    @Test
    void loginFallidoContrasenaIncorrecta() {
        String email = "alba.cruz@gmail.com";
        String contrasenaCorrecta = "albita142003";
        String contrasenaIncorrecta = "12345";

        IDAOLogin idaoLogin = mock(IDAOLogin.class);
        Usuario usuario = new Usuario("Alba Cruz", true, contrasenaCorrecta, email);

        when(idaoLogin.findUserByEmail(email)).thenReturn(usuario);

        LoginService loginService = new LoginService(idaoLogin);

        boolean resultado = loginService.login(email, contrasenaIncorrecta);

        assertThat(resultado, is(false));
    }

    @Test
    void loginFallidoUsuarioNoEncontrado() {
        String email = "desconocido@gmail.com";
        String contrasena = "cualquiera";

        IDAOLogin idaoLogin = mock(IDAOLogin.class);

        when(idaoLogin.findUserByEmail(email)).thenReturn(null);

        LoginService loginService = new LoginService(idaoLogin);

        boolean resultado = loginService.login(email, contrasena);

        assertThat(resultado, is(false));
    }
}
