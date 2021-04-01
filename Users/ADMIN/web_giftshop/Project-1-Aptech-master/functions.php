<?php
    function pdo_connect_mysql() {
        // Update the details below with your MySQL details
        $DATABASE_HOST = 'localhost';
        $DATABASE_USER = 'root';
        $DATABASE_PASS = '';
        $DATABASE_NAME = 'ProductDB';
        try {
            return new PDO('mysql:host=' . $DATABASE_HOST . ';dbname=' . $DATABASE_NAME . ';charset=utf8', $DATABASE_USER, $DATABASE_PASS);
        } catch (PDOException $exception) {
            // If there is an error with the connection, stop the script and display the error.
            exit('Failed to connect to database!');
        }
    }
    // Template header, feel free to customize this
    function template_header($title) {
        $num_items_in_cart = isset($_SESSION['cart']) ? count($_SESSION['cart'])-1 : 0; 
        echo <<<EOT
        <!DOCTYPE html>
        <html>
        
            <head>
                <meta charset="utf-8">
                <title>$title</title>
                <link href="./style.css" rel="stylesheet">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                
            </head>
            <body>
                <header>
                    <div class="content-wrapper">
                        <h1>Shopping Cart System</h1>
                        <nav>
                            <a href="index.php">Home</a>
                            <a href="index.php?page=products">ALL Products</a>
                        </nav>
                        <div class="link-icons">
                            <a href="index.php?page=cart">
                                <i class="fas fa-shopping-cart"></i>
                                <span>$num_items_in_cart</span>
                            </a>
                        </div>
                    </div>


                    
                </header>
                <main>
                


        EOT;
        
        
    }
    // Template footer
    function template_footer() {
        $year = date('Y');
        echo <<<EOT
                </main>
                <footer>
                    <div class="content-wrapper">
                        <p>&copy; $year, Shopping Cart System</p>
                    </div>
                </footer>
                <script src="script.js"></script>
            </body>
        </html>
        EOT;
    }
?>