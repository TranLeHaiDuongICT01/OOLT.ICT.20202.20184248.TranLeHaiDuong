<?php
// Check to make sure the id parameter is specified in the URL
if (isset($_GET['name']) || isset($_GET['id'])) {
    // Prepare statement and execute, prevents SQL injection
    $stmt = $pdo->prepare('SELECT * FROM products WHERE brand = ? && category = ?');
    $stmt->bindParam(1,$_GET['name'],PDO::PARAM_STR);
    $stmt->bindParam(2,$_GET['id'],PDO::PARAM_INT);
    $stmt->execute(); 
    // Fetch the product from the database and return the result as an Array
    $products = $stmt->fetchall(PDO::FETCH_ASSOC); 
$total_products = $pdo->query('SELECT * FROM products WHERE category = '.$_GET['id'].' && brand = "'.$_GET['name'].'"')->rowCount();
}
?>
<?=template_header($_GET['name'])?> 

<?php

$stmt = $pdo->prepare('SELECT * FROM main_categorys ORDER BY id');
$stmt->execute();
$main_categorys = $stmt->fetchAll(PDO::FETCH_ASSOC);


$stmt = $pdo->prepare('SELECT * FROM brands ORDER BY name');
$stmt->execute();
$brands = $stmt->fetchAll(PDO::FETCH_ASSOC);


?>

<nav class="navbar navbar-expand-sm bg-light navbar-light d-flex justify-content-center">  
                <ul class="navbar-nav text-center">

                    <li class="nav-item dropdown  text-center">
                        <a class="nav-link dropdown-toggle" 
                        href="#" 
                        id="navbardrop" data-toggle="dropdown">
                        BRANDS
                        </a> 
                            <div class="dropdown-menu"> 
                            <?php foreach ($brands  as $brand): ?>  
                            <a class="dropdown-item" href="index.php?page=brand&name=<?=$brand['name']?>"><?=$brand['name']?></a> 
                            <?php endforeach; ?>
                    </li>

                    <?php foreach ($main_categorys  as $main_category): ?>  
                    <li class="nav-item dropdown  text-center">
        
                        <a class="nav-link dropdown-toggle" 
                        href="#" 
                        id="navbardrop" data-toggle="dropdown">
                        <?=$main_category['name']?>
                        </a>
                        <?php
                        $main_category_id = (array)$main_category['ID'];
                        $stmt = $pdo->prepare('SELECT * FROM categorys WHERE main_category = ?'); 
                        $stmt->execute($main_category_id);
                        $categorys = $stmt->fetchAll(PDO::FETCH_ASSOC);
                        ?>
                            <div class="dropdown-menu"> 
                            <?php foreach ($categorys  as $category): ?>  
                            <a class="dropdown-item" href="index.php?page=category&id=<?=$category['id']?>"><?=$category['name']?></a> 
        
                            <?php endforeach; ?>
         
                    </li> 
                    <?php endforeach; ?> 
                </ul>
            </nav>





<div class="products content-wrapper">
    <h1>Products</h1>
    <p><?=$total_products?> Products</p>
    <div class="products-wrapper">
        <?php foreach ($products as $product): ?>
        <a href="index.php?page=product&id=<?=$product['id']?>" class="product">
            <img src="imgs/<?=$product['img']?>" width="200" height="200" alt="<?=$product['name']?>">
            <span class="name"><?=$product['name']?></span>
            <span class="price">
                &dollar;<?=$product['price']?>
                <?php if ($product['rrp'] > 0): ?>
                <span class="rrp">&dollar;<?=$product['rrp']?></span>
                <?php endif; ?>
            </span>
        </a>
        <?php endforeach; ?>
    </div>
    <!-- <div class="buttons">
        <?php if ($current_page > 1): ?>
        <a href="index.php?page=products&p=<?=$current_page-1?>">Prev</a>
        <?php endif; ?>
        <?php if ($total_products > ($current_page * $num_products_on_each_page) - $num_products_on_each_page + count($products)): ?>
        <a href="index.php?page=products&p=<?=$current_page+1?>">Next</a>
        <?php endif; ?>
    </div> -->
</div>

<?=template_footer()?>