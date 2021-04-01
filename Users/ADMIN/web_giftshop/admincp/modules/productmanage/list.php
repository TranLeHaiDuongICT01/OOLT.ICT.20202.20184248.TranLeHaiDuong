<?php
    $sql_list_product ="SELECT * FROM tbl_product ORDER BY 	id_product DESC";
    $query_list_product = mysqli_query($mysqli,$sql_list_product);
?>
<p>Liệt kê danh mục sản phẩm</P>
<table style="width:100%" border="1" style="boder-collapse:collapse">
  <tr>
    <th>Id</th>
    <th>Tên Sản Phẩm</th>
    <th>Hình ảnh</th>
    <th>Giá sản phẩm</th>
    <th>Số lượng sản phẩm</th>
    <th>Mã sản phẩm</th>
    <th>Tóm tắt</th>
    <th>Trạng thái</th>
    <th>Quản lý</th>
  </tr>
<?php
    $i = 0;
    while($row = mysqli_fetch_array($query_list_product)){
        $i++;
?>
  <tr>
    <td><?php echo $i ?></td>
    <td><?php echo $row['name_product'] ?></td>
    <td><img src="modules/productmanage/upload/<?php echo $row['images'] ?>" width="200px"></td>
    <td><?php echo $row['price'] ?></td>
    <td><?php echo $row['amount'] ?></td>
    <td><?php echo $row['code_product'] ?></td>
    <td><?php echo $row['summary'] ?></td>
    <td><?php if($row['stus'] == 1){
      echo 'Kích hoạt';
    }else{
      echo 'Ẩn';
    } ?>
    </td>
    <td>
    <a href="modules/productmanage/xuly.php?idproduct=<?php echo $row['id_product'] ?>">Xóa</a>||<a href="
    ?action=productmanage&query=edit&idproduct=<?php echo $row['id_product'] ?>">Sửa</a>
    </td>
  </tr>
<?php
    }
?>
</table>