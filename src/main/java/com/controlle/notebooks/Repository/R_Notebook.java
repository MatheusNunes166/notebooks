package com.controlle.notebooks.Repository;

import com.controlle.notebooks.Model.M_Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Notebook extends JpaRepository<M_Notebook,Long> {

}
