package pe.gob.regioncallao.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.gob.regioncallao.entities.Usuario;
import pe.gob.regioncallao.repositories.IUsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private IUsuarioRepository UsuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = this.UsuarioRepository.findByUsername(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return usuario;
	}

}
