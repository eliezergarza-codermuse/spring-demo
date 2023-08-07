//# # # # # #
//# Entity  #
//# # # # # #
//Jakarta Imports
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;

//# # # # # # # #
//# Repository  #
//# # # # # # # #
//Spring Imports
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//Java Imports
import java.util.List;

//# # # # # #
//# Service #
//# # # # # #
//Spring Base Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Spring Filter & Sort Imports
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

//# # # # # # # #
//# Controller  #
//# # # # # # # #
//Rest Services Mapping
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
//Parameters, Request and Response Mappings
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//# Spring Framework Autowired Service
import org.springframework.beans.factory.annotation.Autowired;