<?php
    include('../../config/connect.php');

    $name_product = $_POST['nameproduct'];
    $code_product = $_POST['code'];
    $price = $_POST['price'];
    $amount = $_POST['amount'];
    $img = $_FILES['image']['name'];
    $img_tmp = $_FILES['image']['tmp_name'];
    $img = time().'_'.$img;
    $summary = $_POST['summary'];
    $content = $_POST['content'];
    $status = $_POST['sttus'];
    //xu ly hinh anh 

if(isset($_POST['addproduct'])){
        //them
        $sql_them = "INSERT INTO tbl_product(name_product,code_product,price,amount,images,summary,content,stus) VALUES('".$name_product."','".$code_product."',
        '".$price."','".$amount."','".$img."','".$summary."','".$content."','".$status."')";

        mysqli_query($mysqli,$sql_them);
        move_uploaded_file($img_tmp,'upload/'.$img);
        header('Location:../../index.php?action=productmanage&query=add');
}

elseif(isset($_POST['editproduct'])){
        //sua
        if($img != ''){
            move_uploaded_file($img_tmp,'upload/'.$img);
            $sql = "SELECT * FROM tbl_product WHERE id_product = '$_GET[idproduct]' LIMIT 1";
        $query =mysqli_query($mysqli,$sql);
        while($row = mysqli_fetch_array($query)){ 
        unlink('upload/'.$row['image']);
        }
            $sql_update = "UPDATE tbl_product SET name_product = '".$name_product."', code_product = '".$code_product."', price = '".$price."', amount = '".$amount."',
                                              images = '".$img."', summary = '".$summary."', content = '".$content."', stus = '".$status."' WHERE id_product = '$_GET[idproduct]'";
                    
        }else{
            $sql_update = "UPDATE tbl_product SET name_product = '".$name_product."',
                                              code_product = '".$code_product."',
                                              price = '".$price."',
                                              amount = '".$amount."',
                                              summary = '".$summary."',
                                              content = '".$content."',
                                              stus = '".$status."'
                                        WHERE id_product = '$_GET[idproduct]'";
        }
        mysqli_query($mysqli,$sql_update);
        header('Location:../../index.php?action=productmanage&query=add');
}

else{
      
        $id = $_GET['idproduct'];
        $sql = "SELECT * FROM tbl_product WHERE id_product = '$id' LIMIT 1";
        $query =mysqli_query($mysqli,$sql);
        while($row = mysqli_fetch_array($query)){ 
        unlink('upload/'.$row['image']);
        }
        $sql_delete = "DELETE FROM tbl_product WHERE id_product ='".$id."'";
        mysqli_query($mysqli,$sql_delete);
        header('Location:../../index.php?action=productmanage&query=add');
    }
?>