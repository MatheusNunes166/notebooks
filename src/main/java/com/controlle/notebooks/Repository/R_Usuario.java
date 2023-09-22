package com.controlle.notebooks.Repository;

import com.controlle.notebooks.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Usuario  extends JpaRepository<M_Usuario, Long> {

}
