<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 include('database.php');

if($_POST){
    $noofpeople = $_POST['noofpeople'];
    $expiryDate = $_POST['expiryDate'];
    $donorId = $_POST['donorId'];
    $lat = $_POST['lat'];
	$long = $_POST['long'];
    $address= $_POST['address'];
    $city = $_POST['city'];
    $province = $_POST['province'];	
	$status = "1";
    $query = "INSERT INTO donations(noofpeople,expiryDate,donorId,lat,long,address, city, province) values('$noofpeople','$expiryDate','$donorId','$lat','$long','$address','$city','$province','$status')";
    
    $result = mysqli_query($conn,$query);
    $array = array();
    $array['success']=false;
    if($result){
        $array['success']=true;
    }
    echo json_decode($array);
    exit;
}
 