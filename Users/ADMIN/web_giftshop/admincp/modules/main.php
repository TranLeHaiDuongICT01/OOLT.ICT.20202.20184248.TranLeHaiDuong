<div class="clear"></div>
<div class="main">
    <?php
        if(isset($_GET['action']) && $_GET['query']){
            $tam =  $_GET['action'];
            $query = $_GET['query'];
        }else{
            $tam = '';
            $query = '';
        }
        if($tam =='quanlydanhmuc'&& $query=='add'){ //trường hợp của quản lý danh mục sản phẩm
            include("modules/quanlydanhmucsp/add.php");
            include("modules/quanlydanhmucsp/list.php");
        }
        elseif($tam =='quanlydanhmuc'&& $query=='edit'){
            include("modules/quanlydanhmucsp/edit.php");
        }
        //trường hợp của quản lý sản phẩm
        elseif($tam =='productmanage'&& $query=='add'){
            include("modules/productmanage/add.php");
            include("modules/productmanage/list.php");
        }
        elseif($tam =='productmanage'&& $query=='edit'){
            include("modules/productmanage/edit.php");
        }
        else{
            include("modules/dashboard.php");
        }
    ?>
</div>