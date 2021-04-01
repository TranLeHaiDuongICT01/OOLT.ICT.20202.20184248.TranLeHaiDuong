<?php
    $sql_list ="SELECT * FROM tbl_danhmuc ORDER BY thutu DESC";
    $query_list = mysqli_query($mysqli,$sql_list);
?>
<p>Liệt kê danh mục sản phẩm</P>
<table style="width:100%" border="1" style="boder-collapse:collapse">
  <tr>
    <th>Id</th>
    <th>Tên danh muc</th>
    <th>Quản lý</th>
  </tr>
<?php
    $i = 0;
    while($row = mysqli_fetch_array($query_list)){
        $i++;
?>
  <tr>
    <td><?php echo $i ?></td>
    <td><?php echo $row['tendanhmuc'] ?></td>
    <td>
    <a href="modules/quanlydanhmucsp/xuly.php?iddanhmuc=<?php echo $row['id_danhmuc'] ?>">Xóa</a>||<a href="
    ?action=quanlydanhmuc&query=edit&iddanhmuc=<?php echo $row['id_danhmuc'] ?>">Sửa</a>
    </td>
  </tr>
<?php
    }
?>
</table>