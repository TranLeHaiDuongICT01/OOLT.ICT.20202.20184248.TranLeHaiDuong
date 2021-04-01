<?php
    $sql_edit_product ="SELECT * FROM tbl_product WHERE id_product='$_GET[idproduct]' LIMIT 1 ";
    $query_edit_product = mysqli_query($mysqli,$sql_edit_product);
?>
<p>Sửa sản phẩm</p>
<table border="1" width=50% style="boder-collapse:collapse">
<?php
    while($row = mysqli_fetch_array($query_edit_product)){
?>
<form method="POST" action="modules/productmanage/xuly.php?idproduct=<?php echo $row['id_product']?>" enctype="multipart/form-data">

 <tr>
    <td>Tên sản phẩm</td>
    <td><input type="text" name="nameproduct" value="<?php echo $row['name_product'] ?>"></td>
  </tr>
  <tr>
    <td>Mã sản phẩm</td>
    <td><input type="text" name="code" value="<?php echo $row['code_product'] ?>"></td>
  </tr>
  <tr>
    <td>Giá sản phẩm</td>
    <td><input type="text" name="price" value="<?php echo $row['price'] ?>"></td>
  </tr>
  <tr>
    <td>Số lượng</td>
    <td><input type="text" name="amount" value="<?php echo $row['amount'] ?>"></td>
  </tr>
  <tr>
    <td>Hình Ảnh</td>
    <td><input type="file" name="image">
      <img src="modules/productmanage/upload/<?php echo $row['images'] ?>" width="200px">
    </td>
  </tr>
  <tr>
    <td>Tóm Tắt</td>
    <td><textarea rows="10"  name="summary" style="resize: none"><?php echo $row['summary'] ?></textarea></td>
  </tr>
  <tr>
    <td>Nội dung</td>
    <td><textarea rows="5" name="content"><?php echo $row['content'] ?></textarea></td>
  </tr>
  <tr>
    <td>Tình trạng</td>
    <td>
      <select name="sttus">
      <?php 
        if($row['sttus'] == 1){
      ?>
            <option value="1" selected>Kích hoạt</option>
            <option value="0">Ẩn</option>
      <?php
        }else{
      ?>
            <option value="1">Kích hoạt</option>
            <option value="0" selected>Ẩn</option>
      <?php
        }
      ?>
      </select>
    </td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="editproduct" value="Sửa sản phẩm"></td>
  </tr>
</form>
<?php
 }
?>
</table>