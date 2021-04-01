<?php
    include('../../config/connect.php');

    $tenloaisp = $_POST['tendanhmuc'];
    $tenthutu = $_POST['thutu'];
    if(isset($_POST['themdanhmuc'])){
        //them
        $sql_them = "INSERT INTO tbl_danhmuc(tendanhmuc,thutu) VALUE('".$tenloaisp."','".$tenthutu."')";
        mysqli_query($mysqli,$sql_them);
        var_dump($mysqli,$sql_them);
        header('Location:../../index.php?action=quanlydanhmuc&query=add');
    }elseif(isset($_POST['suadanhmuc'])){
        //sua
        $sql_update = "UPDATE tbl_danhmuc SET tendanhmuc='".$tenloaisp."',thutu='".$tenthutu."' WHERE id_danhmuc='$_GET[iddanhmuc]'";
        mysqli_query($mysqli,$sql_update);
        header('Location:../../index.php?action=quanlydanhmuc&query=add');
    }else{
        $id = $_GET['iddanhmuc'];
        $sql_delete = "DELETE FROM tbl_danhmuc WHERE id_danhmuc='".$id."'";
        mysqli_query($mysqli,$sql_delete);
        header('Location:../../index.php?action=quanlydanhmuc&query=add');

    }
?>