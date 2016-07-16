<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 include('database.php');

if($_POST){
    $title = $_POST['title'];
    $address= $_POST['address'];
    $type = $_POST['type'];
    $name = $_POST['name'];
    $query = "INSERT INTO users(title,name,address,type) values('$title','$name','$address','$type')";
    
    $result = mysqli_query($conn,$query);
    $array = array();
    $array['success']=false;
    if($result){
        $array['success']=true;
    }
    echo json_decode($array);
    exit;
}
 