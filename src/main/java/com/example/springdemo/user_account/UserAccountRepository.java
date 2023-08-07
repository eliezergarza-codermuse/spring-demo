package com.example.springdemo.user_account;
//Spring Imports
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Java Imports
import java.util.List;

@Repository
/*
 *  Repository<T,ID>
 *      CrudRepository<T,ID>
 *          ListCrudRepository<T,ID>
 *      PagingAndSortingRepository
 *          ListPagingAndSortingRepository
 *
 *   public interface JpaRepository<T,ID> extends ListCrudRepository<T,ID>, ListPagingAndSortingRepository<T,ID>, QueryByExampleExecutor<T>
 */

//public interface UserAccountRepository extends Repository<UserAccount, Long> {
//public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
//public interface UserAccountRepository extends ListCrudRepository<UserAccount, Long> {
//public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
//public interface UserAccountRepository extends ListPagingAndSortingRepository<UserAccount, Long> {
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    @Query (value = "SELECT TOP ?1 * FROM USER_ACCOUNT WHERE ACTIVE=TRUE ORDER BY ID", nativeQuery=true)
    List<UserAccount> findTop(Integer top);
}