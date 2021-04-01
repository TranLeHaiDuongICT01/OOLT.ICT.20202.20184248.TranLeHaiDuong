<p>Thêm san phẩm</p>
<table border="1" width=100%  style="boder-collapse:collapse">
<form method="POST" action="modules/productmanage/xuly.php" enctype="multipart/form-data">
  <tr>
    <td>Tên sản phẩm</td>
    <td><input type="text" name="nameproduct" width></td>
  </tr>
  <tr>
    <td>Mã sản phẩm</td>
    <td><input type="text" name="code"></td>
  </tr>
  <tr>
    <td>Giá sản phẩm</td>
    <td><input type="text" name="price"></td>
  </tr>
  <tr>
    <td>Số lượng</td>
    <td><input type="text" name="amount"></td>
  </tr>
  <tr>
    <td>Hình Ảnh</td>
    <td><input type="file" name="image"></td>
  </tr>
  <tr>
    <td>Tóm Tắt</td>
    <td><textarea rows="10"  name="summary" style="resize: none"></textarea></td>
  </tr>
  <tr>
    <td>Nội dung</td>
    <td><textarea rows="10" name="content" style="resize: none"></textarea></td>
  </tr>
  
  <tr>
    <td>Tình trạng</td>
    <td>
      <select name="sttus">
        <option value="1">Kích hoạt</option>
        <option value="0">Ẩn</option>
      </select>
    </td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="addproduct" value="Thêm sản phẩm"></td>
  </tr>

</form>
</table>