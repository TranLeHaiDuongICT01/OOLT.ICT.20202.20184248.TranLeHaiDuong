<?php
    $sql_edit ="SELECT * FROM tbl_danhmuc WHERE id_danhmuc='$_GET[iddanhmuc]' LIMIT 1 ";
    $query_edit = mysqli_query($mysqli,$sql_edit);
?>
<p>Sửa danh muc san phẩm</p>
<table border="1" width=50% style="boder-collapse:collapse">
<form method="POST" action="modules/quanlydanhmucsp/xuly.php?iddanhmuc=<?php echo $_GET['iddanhmuc']?>">
<?php
    while($dong = mysqli_fetch_array($query_edit)){
?>
  <tr>
    <th>Điền danh mục sản phẩm</th>
  </tr>
  <tr>
      <td>Tên danh mục</td>
    <td><input type="text" value="<?php echo $dong['tendanhmuc'] ?>" name="tendanhmuc"></td>
  </tr>
  <tr>
      <td>Thứ tư</td>
    <td><input type="text" value="<?php echo $dong['thutu'] ?>" name="thutu"></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="suadanhmuc" value="Sửa danh mục sản phẩm"></td>
  </tr>
  <?php
    }
  ?>
</form>
</table>