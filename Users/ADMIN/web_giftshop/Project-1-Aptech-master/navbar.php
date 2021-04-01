<?php

$stmt = $pdo->prepare('SELECT * FROM main_categorys ORDER BY id');
$stmt->execute();
$main_categorys = $stmt->fetchAll(PDO::FETCH_ASSOC);


$stmt = $pdo->prepare('SELECT * FROM brands ORDER BY name');
$stmt->execute();
$brands = $stmt->fetchAll(PDO::FETCH_ASSOC);


?>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark d-flex justify-content-center">  
                <ul class="navbar-nav text-center">
 
                <?php
            if (isset($_GET['category']))
                {
                $category['name'] =($_GET['category']);
                }
                else {$category['name'] = 0 ;}
                            
            ?>
                <li class="nav-item text-center">
                          
 <?php 
if (!isset($_GET['brand']) || $_GET['brand'] == 0) {
echo '
<a class="nav-link" style="color: white;"
href="index.php?page=category&brand=0&category='.$category['name'].'">
ALL BRANDS
</a> 
';
}
else 
{
echo '
<a class="nav-link"
href="index.php?page=category&brand=0&category='.$category['name'].'">
ALL BRANDS
</a>
';
} 
?>

                  </li>

                    <?php foreach ($brands  as $brand): ?>  
                            
                    <li class="nav-item text-center">
                          
                    <?php 
                    if (isset($_GET['brand']) && $_GET['brand'] == $brand['name']) {
                    echo '
                    <a class="nav-link" style="color: white;"
                    href="index.php?page=category&brand='.$brand['name'].'&category='.$category['name'].'">
                    '.strtoupper($brand['name']).'
                    </a> 
                    ';
                    }
                    else 
                    {
                    echo '
                    <a class="nav-link"
                    href="index.php?page=category&brand='.$brand['name'].'&category='.$category['name'].'">
                    '.strtoupper($brand['name']).'
                    </a> 
                    ';
                    } 
                    ?>

 
                            
                    </li>
                            <?php endforeach; ?>

                    
                </ul>
            </nav>

<nav class="navbar navbar-expand-sm bg-light navbar-light d-flex justify-content-center">  
                <ul class="navbar-nav text-center">
 
        <?php
            if (isset($_GET['brand']))
                {
                $brand['name'] =($_GET['brand']);
                }
                else {$brand['name'] = 0 ;}
                            
            ?>
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
                            <a class="dropdown-item" 
                            href="index.php?page=category&brand=<?=$brand['name']?>&category=<?=$category['name']?>">
                            <?=$category['name']?></a> 
                            <?php endforeach; ?>
         
                    </li> 
                    <?php endforeach; ?> 
                </ul>
            </nav>
 
