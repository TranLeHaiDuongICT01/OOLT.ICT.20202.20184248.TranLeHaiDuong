<?php
// Check to make sure the id parameter is specified in the URL
if (isset($_GET['brand']) && isset($_GET['category'])) { 

if ($_GET['brand'] == 0 && $_GET['category'] != 0 ) {
$stmt = $pdo->prepare('SELECT * FROM products WHERE category = ?'); 
$stmt->bindParam(1,$_GET['category'],PDO::PARAM_STR);
$stmt->execute(); 
// Fetch the product from the database and return the result as an Array
$products = $stmt->fetchall(PDO::FETCH_ASSOC); 
$total_products = $pdo->query('SELECT * FROM products WHERE category = "'.$_GET['category'].'"')->rowCount();
}

else if ($_GET['category'] == 0 && $_GET['brand'] != 0 ) {
$stmt = $pdo->prepare('SELECT * FROM products WHERE brand = ?'); 
$stmt->bindParam(1,$_GET['brand'],PDO::PARAM_STR);
$stmt->execute(); 
// Fetch the product from the database and return the result as an Array
$products = $stmt->fetchall(PDO::FETCH_ASSOC); 
$total_products = $pdo->query('SELECT * FROM products WHERE brand = "'.$_GET['brand'].'"')->rowCount();
}

else if ($_GET['category'] != 0 && $_GET['brand'] != 0 ) {
    // Prepare statement and execute, prevents SQL injection
    $stmt = $pdo->prepare('SELECT * FROM products WHERE brand = ? && category = ?');
    $stmt->bindParam(1,$_GET['brand'],PDO::PARAM_STR);
    $stmt->bindParam(2,$_GET['category'],PDO::PARAM_STR);
    $stmt->execute(); 
    // Fetch the product from the database and return the result as an Array
    $products = $stmt->fetchall(PDO::FETCH_ASSOC); 
$total_products = $pdo->query('SELECT * FROM products WHERE category = "'.$_GET['category'].'" && brand = "'.$_GET['brand'].'"')->rowCount();
}

else {
    
    $stmt = $pdo->prepare('SELECT * FROM products');  
    $stmt->execute(); 
    // Fetch the product from the database and return the result as an Array
    $products = $stmt->fetchall(PDO::FETCH_ASSOC); 
    $total_products = $pdo->query('SELECT * FROM products')->rowCount();
    }
}





?>



<?=template_header('a')?> 

<?php include 'navbar.php';?>
 
<div class="products content-wrapper">
    <?php
    if (isset($_GET['category']) && $_GET['category'] != 0 && $_GET['category'] != NULL)  {

        $stmt = $pdo->prepare('SELECT * FROM categorys WHERE name = "'.$_GET['category'].'"');  
        $stmt->execute(); 
        // Fetch the product from the database and return the result as an Array
        $categorys = $stmt->fetchall(PDO::FETCH_ASSOC);  
        
            foreach ($categorys  as $category):
            $main_catogery_id = $category['main_category'];
            endforeach;
        
        $stmt = $pdo->prepare('SELECT * FROM main_categorys WHERE ID = '.$main_catogery_id);  
        $stmt->execute(); 
        // Fetch the product from the database and return the result as an Array
        $main_categorys = $stmt->fetchall(PDO::FETCH_ASSOC);  
            foreach ($main_categorys  as $main_category): 
            $main_catogery_name = $main_category['name'];
            endforeach;
    
        echo '<h1>'.strtoupper($main_catogery_name).'>'.strtoupper($_GET['category']).'</h1>';
    }
    ?> 
    <?php if (isset($total_products)) echo '<p>'.$total_products.' Products</p>'?>
    <div class="products-wrapper">
        <?php if (isset($products)){foreach ($products as $product): ?>
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
        <?php endforeach; }?>
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