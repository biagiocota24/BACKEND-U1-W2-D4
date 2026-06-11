import classes.Customer;
import classes.Order;
import classes.Product;
import datiFissi.Categories;
import datiFissi.OrderStatus;

void main() {

    // CLIENTI A CASO
    Customer c1 = new Customer("biagio", 5);
    Customer c2 = new Customer("Topo Giggio", 2);
    Customer c3 = new Customer("Gigi", 2);
    Customer c4 = new Customer("Giuseppe", 3);


    //20 PRODOTTI A CASO
    Product p1 = new Product("La Divina Commedia", Categories.libri, 15);
    Product p2 = new Product("Harry Potter", Categories.libri, 22);
    Product p3 = new Product("Il Nome della Rosa", Categories.libri, 18);
    Product p4 = new Product("Sapiens", Categories.libri, 20);
    Product p5 = new Product("1984", Categories.libri, 12);
    Product p6 = new Product("Passeggino", Categories.baby, 250);
    Product p7 = new Product("Lettino", Categories.baby, 180);
    Product p8 = new Product("Biberon set", Categories.baby, 25);
    Product p9 = new Product("Fasciatoio", Categories.baby, 90);
    Product p10 = new Product("Baby monitor", Categories.baby, 65);
    Product p11 = new Product("Maglia calcio", Categories.boys, 40);
    Product p12 = new Product("Zaino scuola", Categories.boys, 55);
    Product p13 = new Product("Scarpe da ginnastica", Categories.boys, 70);
    Product p14 = new Product("Felpa con cappuccio", Categories.boys, 35);
    Product p15 = new Product("Bermuda sportivi", Categories.boys, 28);
    Product p16 = new Product("La pesca", Categories.libri, 300);
    Product p17 = new Product("Enciclopedia", Categories.libri, 120);
    Product p18 = new Product("Seggiolino auto", Categories.baby, 150);
    Product p19 = new Product("Pannolini confezione", Categories.baby, 18);
    Product p20 = new Product("Giubbotto", Categories.boys, 85);
    Product p21 = new Product("Avventure nel bosco", Categories.libri, 200);

    //LISTA DI TUTTI I PRODOTTI
    List<Product> listaProdotti = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21));


    // ORDINI
    Order o1 = new Order(OrderStatus.inLavorazione, c1);
    o1.addProduct(p1);
    o1.addProduct(p9);
    o1.addProduct(p20);
    o1.addProduct(p13);

    Order o2 = new Order(OrderStatus.confermato, c2);
    o2.addProduct(p2);
    o2.addProduct(p11);
    o2.addProduct(p6);

    Order o3 = new Order(OrderStatus.spedito, c3);
    o3.addProduct(p5);
    o3.addProduct(p15);
    o3.addProduct(p17);
    o3.addProduct(p4);
    o3.addProduct(p2);

    Order o4 = new Order(OrderStatus.inAttesa, c4);
    o4.addProduct(p8);
    o4.addProduct(p18);
    o4.addProduct(p3);
    o4.addProduct(p16);
    o4.addProduct(p7);

    //LISTA ORDINI
    List<Order> listaOrdini = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));
//
//    //ESERCIZIO 1
//    System.out.println("---------------libri---------------------");
//    // LISTA DI PRODOTTI CATEGORIA LIBRO E PREZZO MAGGIORE DI 100
//    List<Product> soloLibriSopra100 = listaProdotti.stream().filter(product -> product.getCategory().equals(Categories.libri) && product.getPrice() > 100).toList();
//    soloLibriSopra100.stream().forEach(libro -> System.out.println(libro));
//
//    //ESERCIZIO 2
//    System.out.println("---------------Baby---------------------");
//    // LISTA DI ORDINI CON PRODOTTI DI CATEGORIA BABY
////    List<Product> soloProdottiPerBaby = listaProdotti.stream().filter(product -> product.getCategory().equals(Categories.baby)).toList();
////    soloProdottiPerBaby.stream().forEach(product -> System.out.println(product));
//    List<Order> soloOrdiniConProdottiBaby = listaOrdini.stream().filter(order -> order.getProducts()
//            .stream().anyMatch(product -> product.getCategory()
//                    .equals(Categories.baby))).toList();
//    soloOrdiniConProdottiBaby.forEach(order -> System.out.println(order));
//
//    //ESERCIZIO 3
//    System.out.println("---------------Boys---------------------");
//    System.out.println("*************** Prezzi di listino ****************");
//    List<Product> soloProdottiPerBoys = listaProdotti.stream().filter(product -> product.getCategory().equals(Categories.boys)).toList();
//    soloProdottiPerBoys.stream().forEach(product -> System.out.println(product + "Prezzo di listino"));
//    System.out.println("*************** Prezzi scontati ****************");
//    List<Product> soloProdottiPerBoysScontati = soloProdottiPerBoys.stream().map(product -> product.setPrice(product.getPrice() * 0.9)).toList();
//    soloProdottiPerBoysScontati.stream().forEach(product -> System.out.println(product + "Sconto del 10% applicato"));
//
//    //ESERCIZIO 4
//    System.out.println("---------------Ordini tier 2---------------------");
//    //DATE
//    LocalDate today = LocalDate.now();
//    LocalDate yesterday = today.minusDays(1);
//    LocalDate tomorrow = today.plusDays(1);
//    //
//    List<Order> soloCustomer2 = listaOrdini.stream().filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate().isAfter(yesterday) && order.getOrderDate().isBefore(tomorrow)).toList();
//    soloCustomer2.forEach(order -> System.out.println(order));
//    System.out.println("----------------------------------------------------");
//    List<Product> soloProdottiDaCustomer2 = soloCustomer2.stream().flatMap(order -> order.getProducts().stream()).toList();
//    soloProdottiDaCustomer2.forEach(System.out::println);


    // ESERCIZIO 1 STREAM() 2

    Map<Customer, List<Order>> ordiniPerClieete = listaOrdini.stream().collect(Collectors.groupingBy(order -> order.getCustomer()));
    ordiniPerClieete.forEach((customer, orders) -> System.out.println("customer :" + customer.getName() + " order : " + orders));

    // ESERCIZIO 2 STREAM() 2
    ordiniPerClieete.forEach((customer, orders) -> {
        double totaleCliente = orders.stream().mapToDouble(order -> order.calculateTotal()).sum();
        System.out.println("customer :" + customer.getName() + " Total : " + totaleCliente);
    });

    // ESERCIZIO 3 STREAM() 2

    List<Product> prodottiDalPiuCostoso = listaProdotti.stream().sorted(Comparator.comparingDouble((Product product) -> product.getPrice()).reversed()).limit(5).toList();
    prodottiDalPiuCostoso.forEach(product -> System.out.println(product));

    // ESERCIZIO 4 STREAM() 2

    OptionalDouble mediaOrdiniprov = listaOrdini.stream().mapToDouble(order -> order.calculateTotal()).average();
    System.out.println(mediaOrdiniprov);

    List<Order> listaOrdini2 = new ArrayList<>();

    double mediaOrdini = listaOrdini2.stream().mapToDouble(order -> order.calculateTotal()).average().orElse(0.0);
    System.out.println("media in double : " + mediaOrdini);

//    if (mediaOrdiniprov.isPresent()) {
//        double mediaOrdini = mediaOrdiniprov.getAsDouble();
//        System.out.println("media come double : "+mediaOrdini);
//    } else {
//        System.out.println("La media non e stata calcolata");
//    }


    // ESERCIZIO 5 STREAM() 2

//    listaProdotti.stream().collect(Collectors.groupingBy(product -> product.getCategory())).forEach((categories, products) -> products.stream().collect(Collectors.summingDouble(product -> product.getPrice())));
    Map<Categories, Double> categorieESomma = listaProdotti.stream().collect(Collectors.groupingBy(product -> product.getCategory(), Collectors.summingDouble(product -> product.getPrice())));

    categorieESomma.forEach((category, somma) -> System.out.println("Category : " + category + " = " + somma));


    // TROVO TUTTI I PRODOTTI DISTINTI DA CLIENTI DI TIER 2 E RIMUOVO SE PRESENTI I DUPLICATI

    List<Product> soloProdottiDaClientiTier2 = listaOrdini.stream().filter(order -> order.getCustomer().getTier() == 2).flatMap(order -> order.getProducts().stream()).distinct().toList();
    soloProdottiDaClientiTier2.forEach(product -> System.out.println("Prodotto : " + product));

    // RAGGRUPPA I PRODOTTI PER CATEGORIA E MOSTRO QUANTI PRODOTTI CI SONO PER CATEGORIA

    //Map<Categories, List<Product>> prodottiACategoria = listaProdotti.stream().collect(Collectors.groupingBy((product) -> product.getCategory()));
    Map<Categories, Long> prodottiACategoria = listaProdotti.stream().collect(Collectors.groupingBy((product) -> product.getCategory(), Collectors.counting()));
    prodottiACategoria.forEach((category, products) -> System.out.println("categoria : " + category + " prodotti : " + " " + products));

    // TROVO I 3 ORDINI PER IL TOTALE PIU ALTO
    List<Order> ordiniPiuCari = listaOrdini.stream().sorted(Comparator.comparingDouble((Order order) -> order.calculateTotal()).reversed()).limit(3).toList();
    ordiniPiuCari.forEach(order -> System.out.println("Cliente : " + order.getCustomer().getName() + " | Totale ordine : " + order.calculateTotal() + order));

    // RAGRUPPO NEI DIVERSI STATUS E CALCOLO IL PREZZO MEDIO DEI PRODOTTI
    Map<OrderStatus, List<Order>> oridiniPerStato = listaOrdini.stream().collect(Collectors.groupingBy(order -> order.getStatus()));
    oridiniPerStato.forEach((status, orders) -> System.out.println("stato : " + status + " | Ordini : " + orders));
    oridiniPerStato.forEach((status, orders) -> {
        double media = orders.stream().flatMap(order -> order.getProducts().stream()).mapToDouble(product -> product.getPrice()).average().orElse(0.0);
        System.out.println("Stato : " + status + " media = " + media);
    });

    // PRENDO TUTTI GLI ORDINI IN ATTESA , ESTRAGGO TUTTI I LORO PRODOTTI E CALCOLO IL VALORE COMPLESSIVO DI TUTTI QUESTI PRODOTTI

    double sommaOrdini = listaOrdini.stream().filter(order -> order.getStatus().equals(OrderStatus.inAttesa) || order.getStatus().equals(OrderStatus.confermato)).flatMap(order -> order.getProducts().stream()).mapToDouble(product -> product.getPrice()).sum();
    System.out.println("somma : " + sommaOrdini);
}

