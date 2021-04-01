<?=template_header('Invoice')?>


<?php 


$products_in_cart = isset($_SESSION['cart']) ? $_SESSION['cart'] : array();
$products = array();
$subtotal = 0.00; 
// If there are products in cart
if ($products_in_cart) {
    // There are products in the cart so we need to select those products from the database
    // Products in cart array to question mark string array, we need the SQL statement to include IN (?,?,?,...etc)
    $array_to_question_marks = implode(',', array_fill(0, count($products_in_cart), '?'));
    $stmt = $pdo->prepare('SELECT * FROM products WHERE id IN (' . $array_to_question_marks . ')');
    // We only need the array keys, not the values, the keys are the id's of the products
    $stmt->execute(array_keys($products_in_cart));
    // Fetch the products from the database and return the result as an Array
    $products = $stmt->fetchAll(PDO::FETCH_ASSOC);
    // Calculate the subtotal
    foreach ($products as $product) {
        $subtotal += (float)$product['price'] * (int)$products_in_cart[$product['id']];
    }
}

if (isset($_POST['invoice']) && isset($_SESSION['cart']) && !empty($_SESSION['cart'])) {
$stmt = $pdo->prepare('INSERT INTO `invoices` '
.'(`name`, `phone`, `address`, `TotalCost`, `CreateDate`, `status`)'.
' VALUES (?, ?, ?, ?, ?, "pending");'); 
$stmt->bindParam(1,$_POST['customer_name'],PDO::PARAM_STR);
$stmt->bindParam(2,$_POST['phone'],PDO::PARAM_INT);
$stmt->bindParam(3,$_POST['address'],PDO::PARAM_STR);
$stmt->bindParam(4,$_POST['totalcost'],PDO::PARAM_STR); 


date_default_timezone_set("Asia/Ho_Chi_Minh");
$date = date("Y-m-d h:i:sa");
$stamp = strtotime($date); // get unix timestamp
$time_in_ms = $stamp*1000;
$stmt->bindParam(5,$date,PDO::PARAM_STR);  
$stmt->execute(); 

$BillID = $pdo->lastInsertId(); 
 
foreach ($products as $product){  
$stmt = $pdo->prepare('INSERT INTO `billing` '
.'(`BillID`, `name`, `price` ,`quantity`, `cost`)'.
' VALUES (?, ?, ?, ?, ?);');  
$stmt->bindParam(1,$BillID,PDO::PARAM_INT);
$stmt->bindParam(2,$product['name'],PDO::PARAM_STR);
$stmt->bindParam(3,$product['price'],PDO::PARAM_STR); 
$stmt->bindParam(4,$products_in_cart[$product['id']],PDO::PARAM_INT); 
$cost = ($product['price'] * $products_in_cart[$product['id']]);
$stmt->bindParam(5,$cost ,PDO::PARAM_STR); 

$stmt->execute(); 
}

 
header('Location: index.php?page=placeorder');
    exit;
}

    // If there are products in cart
    if ($products_in_cart) {
        // There are products in the cart so we need to select those products from the database
        // Products in cart array to question mark string array, we need the SQL statement to include IN (?,?,?,...etc)
        $array_to_question_marks = implode(',', array_fill(0, count($products_in_cart), '?'));
        $stmt = $pdo->prepare('SELECT * FROM products WHERE id IN (' . $array_to_question_marks . ')');
        // We only need the array keys, not the values, the keys are the id's of the products
        $stmt->execute(array_keys($products_in_cart));
        // Fetch the products from the database and return the result as an Array
        $products = $stmt->fetchAll(PDO::FETCH_ASSOC);
        // Calculate the subtotal
        foreach ($products as $product) {
            $subtotal += (float)$product['price'] * (int)$products_in_cart[$product['id']];
        }  }?>

<div class="cart content-wrapper">
    <h1>Invoice's Information</h1>
<form action="index.php?page=invoice" method="post">    
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label >Your name</label>
      <input type="text" class="form-control"  placeholder="Your name" required name="customer_name"> 
    </div> 
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label >Phone number</label>
      <input type="number" min="0" class="form-control" required name="phone"> 
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label >Address</label>
      <input type="text" class="form-control"  placeholder="address" name="address" required> 
    </div> 
  </div>
   
        <table>
            <thead>
                <tr>
                    <td colspan="2">Product</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Total</td>
                </tr>
            </thead>
            <tbody>
        <?php foreach ($products as $product): 
                    
                     
                    if (isset($_POST["remove$product[id]"]) ) 
                        { 
                        unset($_SESSION['cart'][$product['id']]);
                        header('location: index.php?page=cart'); 
                        } 
                    ?> 
                <tr>
                
                    <td class="img">
                        <a href="index.php?page=product&id=<?=$product['id']?>">
                            <img src="imgs/<?=$product['img']?>" width="50" height="50" alt="<?=$product['name']?>">
                        </a>
                    </td>
                    <td>
                        <a href="index.php?page=product&id=<?=$product['id']?>"><?=$product['name']?></a> 
                    </td>
                    <td class="price">&dollar;<?=$product['price']?></td>
                    <td class="quantity">
                        <p name="quantity-<?=$product['id']?>" required><?=$products_in_cart[$product['id']]?></p>
                    </td>
                    <td class="price">&dollar;<?=$product['price'] * $products_in_cart[$product['id']]?></td> 
                </tr>
                <?php endforeach; ?>


            </tbody>
        </table>
        <div class="subtotal">
            <span class="text">Subtotal</span>
            <input type="text" value="<?=$subtotal?>" name="totalcost" hidden>
            <span class="price">&dollar;<?=$subtotal?></span>
        </div>  
        <div class="buttons">  
            <input type="submit" value="Send order" name="invoice">
        </div>
    </form>
</div>


<!-- 
<div class="placeorder content-wrapper">
    <h1>Your Order Has Been Placed</h1>
    <p>Thank you for ordering with us, we'll contact you by email with your order details.</p>
</div> -->

<?=template_footer()?> 