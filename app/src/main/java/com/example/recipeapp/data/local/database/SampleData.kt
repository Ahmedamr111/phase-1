package com.example.recipeapp.data.local.database

import com.example.recipeapp.data.local.entity.RecipeEntity

/**
 * Pre-populated initial recipes (22 recipes) covering Egyptian and international cuisines.
 */
object SampleData {
    val initialRecipes = listOf(
        RecipeEntity(
            id = 1,
            title = "Authentic Egyptian Koshari",
            description = "Egypt's national dish made of rice, lentils, macaroni, topped with spiced tomato sauce, garlic vinegar (da'ah), and crispy fried onions.",
            category = "Egyptian",
            prepTimeMinutes = 50,
            servings = 6,
            ingredients = "1 cup brown lentils\n1 cup Egyptian short-grain rice\n1 cup elbow macaroni\n1 cup chickpeas (cooked)\n2 cups crispy fried onions\n4 cups tomato sauce\n4 cloves garlic minced\n2 tbsp vinegar\n1 tsp cumin\nSalt & black pepper to taste",
            instructions = "1. Boil lentils until tender, then cook rice with lentil broth for extra flavor.\n2. In a separate pot, boil macaroni in salted water until al dente.\n3. Prepare spicy tomato sauce with sautéed garlic, vinegar, cumin, and blended tomatoes.\n4. Make da'ah by mixing minced garlic, vinegar, lemon juice, cumin, and warm water.\n5. Layer rice and lentils, pasta, chickpeas, spicy sauce, and generous fried onions on top.",
            isFavorite = true,
            sourceUrl = "https://en.wikipedia.org/wiki/Kushari"
        ),
        RecipeEntity(
            id = 2,
            title = "Egyptian Ful Medames",
            description = "Slow-simmered fava beans seasoned with cumin, garlic, lemon juice, extra virgin olive oil, and served with warm baladi bread.",
            category = "Egyptian",
            prepTimeMinutes = 20,
            servings = 4,
            ingredients = "2 cans fava beans (or 2 cups slow-cooked dried fava beans)\n3 cloves minced garlic\n1/4 cup extra virgin olive oil\nJuice of 1 fresh lemon\n1 tsp ground cumin\n1/2 tsp chili flakes\n1 diced tomato\nFresh parsley for garnish\nWarm Egyptian baladi bread",
            instructions = "1. Heat fava beans in a saucepan with a splash of water over medium-low heat.\n2. Lightly mash half the beans with a fork for a creamy texture.\n3. Stir in minced garlic, ground cumin, salt, and freshly squeezed lemon juice.\n4. Drizzle generously with olive oil and top with diced tomatoes and chopped parsley.\n5. Serve immediately with warm baladi bread and pickled vegetables.",
            isFavorite = true,
            sourceUrl = "https://en.wikipedia.org/wiki/Ful_medames"
        ),
        RecipeEntity(
            id = 3,
            title = "Egyptian Molokhia with Rice",
            description = "Traditional green jute mallow soup prepared with rich chicken broth and the iconic sizzling garlic and coriander taksha.",
            category = "Egyptian",
            prepTimeMinutes = 40,
            servings = 5,
            ingredients = "500g finely minced fresh or frozen molokhia leaves\n4 cups rich homemade chicken broth\n6 cloves garlic, crushed\n2 tbsp ground dry coriander\n2 tbsp ghee or butter\nSalt and white pepper to taste\nEgyptian white rice with vermicelli to serve",
            instructions = "1. Bring chicken broth to a gentle simmer in a pot over medium heat.\n2. Whisk in the finely minced molokhia vigorously until smooth; do not let it boil vigorously or cover the pot.\n3. In a small frying pan, melt ghee and sauté crushed garlic with ground coriander until golden and aromatic (taksha).\n4. Pour the sizzling taksha onto the molokhia soup while gasping traditional 'shah’a'.\n5. Serve piping hot alongside vermicelli rice and roasted chicken.",
            isFavorite = false,
            sourceUrl = "https://en.wikipedia.org/wiki/Mulukhiyah"
        ),
        RecipeEntity(
            id = 4,
            title = "Cairo-Style Hawawshi",
            description = "Crispy pita bread stuffed with spiced minced beef, onions, bell peppers, fresh herbs, and baked to golden perfection.",
            category = "Egyptian",
            prepTimeMinutes = 35,
            servings = 4,
            ingredients = "500g minced beef (20% fat)\n4 fresh baladi pita breads\n1 large onion finely grated\n1 green bell pepper finely chopped\n1 hot chili pepper finely chopped\n1/4 cup fresh parsley\n1 tsp 7-spice mix\n1/2 tsp nutmeg\nSalt and black pepper\nOlive oil or melted butter for brushing",
            instructions = "1. In a large bowl, mix minced meat with grated onion, peppers, parsley, and all spices until cohesive.\n2. Cut a small slit into each pita pocket and spread meat mixture evenly inside to the edges.\n3. Brush both sides of the bread lightly with olive oil or butter.\n4. Wrap each loaf in parchment paper and bake at 200°C (400°F) for 20-25 minutes until crispy.\n5. Serve hot with tahini dip and pickles.",
            isFavorite = true,
            sourceUrl = "https://en.wikipedia.org/wiki/Hawawshi"
        ),
        RecipeEntity(
            id = 5,
            title = "Egyptian Mahshi (Stuffed Zucchini & Grape Leaves)",
            description = "Delicately cored zucchini and grape leaves stuffed with spiced tomato rice, dill, coriander, and mint.",
            category = "Egyptian",
            prepTimeMinutes = 75,
            servings = 6,
            ingredients = "1 kg zucchini and eggplants cored\n250g grape leaves blanched\n2 cups short-grain rice washed\n2 cups tomato puree\n2 finely chopped onions\n1 cup fresh chopped dill, coriander, and mint\n1/4 cup vegetable oil\n1 tbsp cumin\n3 cups spiced broth for cooking",
            instructions = "1. Sauté onions in oil until golden, then add tomato puree and spices; simmer for 10 minutes.\n2. Remove from heat, stir in washed rice and fresh herbs.\n3. Stuff cored vegetables 3/4 full to leave room for rice expansion, and roll grape leaves tightly.\n4. Arrange in a heavy-bottomed pot, pour seasoned hot broth over them.\n5. Bring to a boil, then cover and simmer on low heat for 45 minutes until cooked through.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 6,
            title = "Classic Umm Ali",
            description = "Warm traditional Egyptian bread pudding made with puff pastry, milk, heavy cream, toasted nuts, and coconut.",
            category = "Dessert",
            prepTimeMinutes = 35,
            servings = 6,
            ingredients = "400g baked puff pastry sheets (or palmiers)\n4 cups whole milk\n1 cup sweetened condensed milk or 3/4 cup sugar\n1 cup thick whipping cream (eshta)\n1/2 cup slivered almonds\n1/4 cup pistachios crushed\n1/4 cup golden raisins\n1/4 cup shredded coconut\n1 tsp vanilla extract",
            instructions = "1. Break baked puff pastry into bite-sized pieces and layer into an oven-safe baking dish.\n2. Scatter toasted almonds, pistachios, raisins, and coconut throughout the pastry layers.\n3. Heat milk with sugar/condensed milk and vanilla until steaming, then pour over the pastry.\n4. Spread fresh cream (eshta) evenly over the top surface.\n5. Broil in the oven for 8-10 minutes until bubbling and golden brown on top. Serve warm.",
            isFavorite = true,
            sourceUrl = "https://en.wikipedia.org/wiki/Om_Ali"
        ),
        RecipeEntity(
            id = 7,
            title = "Egyptian Ta'ameya (Fava Bean Falafel)",
            description = "Crispy green falafel patties made with dried split fava beans, fresh cilantro, dill, leek, and coated with sesame seeds.",
            category = "Breakfast",
            prepTimeMinutes = 30,
            servings = 4,
            ingredients = "500g split peeled fava beans (soaked overnight)\n1 small onion\n1 bunch fresh cilantro\n1 bunch fresh dill\n1 leek or spring onion\n5 cloves garlic\n1 tbsp ground coriander\n1 tsp baking soda\nSesame seeds for coating\nVegetable oil for deep frying",
            instructions = "1. Drain soaked fava beans thoroughly and place in a food processor with herbs, garlic, and onion.\n2. Pulse until a fluffy, vibrant green dough forms; season with coriander, salt, and cumin.\n3. Dissolve baking soda into the mixture right before frying for optimal puffiness.\n4. Form small patties, press sesame seeds into both sides, and fry in hot oil until deeply golden.\n5. Drain on paper towels and serve with tahina and warm pita.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 8,
            title = "Creamy Roz Bel Laban",
            description = "Fragrant Egyptian rice pudding flavored with mastic and rose water, topped with toasted cinnamon and pistachio nuts.",
            category = "Dessert",
            prepTimeMinutes = 40,
            servings = 5,
            ingredients = "1/2 cup short-grain Egyptian rice\n4 cups whole milk\n1/2 cup heavy cream\n1/2 cup sugar\n2 tbsp cornstarch dissolved in 1/4 cup cold milk\n1 tsp rose water\n1 pinch ground mastic (optional)\nGround cinnamon and crushed pistachios for garnish",
            instructions = "1. Simmer rice in 1.5 cups of water until fully tender and water is absorbed.\n2. Add milk, heavy cream, and sugar; bring to a gentle simmer while stirring frequently.\n3. Whisk in the dissolved cornstarch and cook for 5 minutes until thickened.\n4. Stir in rose water and mastic, then ladle into dessert bowls.\n5. Chill in the refrigerator for at least 3 hours; garnish before serving.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 9,
            title = "Traditional Shakshuka",
            description = "Poached eggs nestled in a savory, spiced stew of ripe tomatoes, bell peppers, onions, cumin, and paprika.",
            category = "Breakfast",
            prepTimeMinutes = 25,
            servings = 3,
            ingredients = "4 large eggs\n1 tbsp olive oil\n1 medium onion, diced\n1 red bell pepper, chopped\n2 cloves garlic, minced\n1 can (400g) crushed tomatoes\n1 tsp ground cumin\n1 tsp paprika\nSalt & black pepper\nFresh cilantro for topping",
            instructions = "1. Sauté onion and red pepper in olive oil until soft and sweet.\n2. Add garlic, cumin, and paprika; cook for 1 minute until fragrant.\n3. Pour in crushed tomatoes and simmer for 10 minutes until sauce thickens.\n4. Use a wooden spoon to make 4 small wells in the sauce and gently crack eggs into them.\n5. Cover pan and simmer on low for 5-8 minutes until egg whites are set and yolks are runny.",
            isFavorite = true,
            sourceUrl = "https://en.wikipedia.org/wiki/Shakshouka"
        ),
        RecipeEntity(
            id = 10,
            title = "Mediterranean Greek Salad",
            description = "Crisp cucumbers, vine-ripened tomatoes, red onion, Kalamata olives, and rich Greek feta cheese with oregano vinaigrette.",
            category = "Vegetarian",
            prepTimeMinutes = 15,
            servings = 4,
            ingredients = "3 ripe vine tomatoes cut into wedges\n1 English cucumber sliced\n1/2 red onion thinly sliced\n1/2 cup Kalamata olives pitted\n200g Greek feta cheese block\n3 tbsp extra virgin olive oil\n1 tbsp red wine vinegar\n1 tsp dried oregano\nSea salt and cracked black pepper",
            instructions = "1. Place tomatoes, cucumbers, red onion, and Kalamata olives into a shallow bowl.\n2. Whisk extra virgin olive oil, red wine vinegar, salt, and black pepper together in a small bowl.\n3. Drizzle vinaigrette over the vegetables and toss gently.\n4. Place the slab of feta cheese on top and sprinkle with dried wild oregano.\n5. Serve immediately with crusty sourdough bread.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 11,
            title = "Classic Italian Carbonara",
            description = "Silky pasta coated in a luxurious emulsion of egg yolks, Pecorino Romano cheese, crisp guanciale, and freshly cracked black pepper.",
            category = "Dinner",
            prepTimeMinutes = 25,
            servings = 4,
            ingredients = "400g spaghetti or rigatoni\n150g guanciale or pancetta cubed\n4 large egg yolks + 1 whole egg\n1 cup freshly grated Pecorino Romano cheese\nFreshly cracked black pepper\nSea salt for pasta water",
            instructions = "1. Cook pasta in a pot of salted boiling water until 1 minute before al dente.\n2. Meanwhile, fry guanciale in a large skillet over medium heat until crispy; remove skillet from heat.\n3. Whisk egg yolks, whole egg, Pecorino Romano, and black pepper in a bowl to form a thick paste.\n4. Transfer hot pasta into the skillet with guanciale and toss to coat in rendered fat.\n5. Pour in egg mixture with 1/2 cup of starchy pasta water, tossing rapidly off the heat to create a silky cream.",
            isFavorite = true,
            sourceUrl = "https://en.wikipedia.org/wiki/Carbonara"
        ),
        RecipeEntity(
            id = 12,
            title = "Neapolitan Margherita Pizza",
            description = "Handmade pizza with thin fermented crust, San Marzano tomato sauce, fresh mozzarella di bufala, and fragrant basil leaves.",
            category = "Dinner",
            prepTimeMinutes = 30,
            servings = 3,
            ingredients = "1 ball fermented pizza dough (250g)\n1/2 cup San Marzano crushed tomatoes\n150g fresh mozzarella cheese torn\nFresh basil leaves\n1 tbsp extra virgin olive oil\nPinch of sea salt",
            instructions = "1. Preheat oven with a pizza stone to maximum temperature (250°C / 500°F).\n2. Stretch dough by hand into a 12-inch round with raised outer rim.\n3. Spread crushed tomatoes evenly over dough, leaving 1 inch around edges.\n4. Distribute mozzarella pieces and drizzle with extra virgin olive oil.\n5. Bake for 8-10 minutes until crust is blistered and cheese is melted; top with fresh basil.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 13,
            title = "Aromatic Chicken Biryani",
            description = "Fragrant long-grain basmati rice layered with spiced marinated chicken, saffron milk, fried onions, and fresh mint.",
            category = "Lunch",
            prepTimeMinutes = 60,
            servings = 6,
            ingredients = "600g chicken thighs bone-in\n2 cups aged basmati rice\n1 cup plain yogurt\n2 large onions thinly sliced and fried golden\n2 tbsp biryani masala spice mix\n1 tsp turmeric powder\n1 pinch saffron soaked in 3 tbsp warm milk\nFresh mint and cilantro leaves\n2 tbsp ghee",
            instructions = "1. Marinate chicken in yogurt, biryani spices, garlic, ginger, and half the fried onions for 1 hour.\n2. Parboil basmati rice with whole spices (cardamom, cloves, bay leaf) until 70% cooked.\n3. In a heavy pot, sear marinated chicken until halfway cooked.\n4. Layer parboiled rice on top of chicken; drizzle saffron milk, ghee, mint, and remaining fried onions.\n5. Seal pot tightly with foil and lid, cook on low heat (dum) for 25 minutes.",
            isFavorite = true,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 14,
            title = "Fresh Guacamole & Corn Chips",
            description = "Creamy Hass avocados mashed with lime juice, diced jalapeño, red onion, cilantro, and served with crisp tortilla chips.",
            category = "Vegetarian",
            prepTimeMinutes = 15,
            servings = 4,
            ingredients = "3 ripe Hass avocados\nJuice of 1 fresh lime\n1/4 cup red onion finely chopped\n1 jalapeño seeded and minced\n1/4 cup fresh cilantro chopped\n1 small Roma tomato seeded and diced\n1/2 tsp sea salt\nBag of corn tortilla chips",
            instructions = "1. Cut avocados in half, remove pits, and scoop flesh into a molcajete or bowl.\n2. Mash avocados with a fork, leaving some chunks for texture.\n3. Add diced onion, jalapeño, cilantro, tomato, and salt.\n4. Squeeze fresh lime juice over mixture and fold gently to combine.\n5. Taste and adjust seasoning; serve immediately with tortilla chips.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 15,
            title = "Gourmet Smash Beef Burger",
            description = "Two crispy-edged smashed beef patties with melted cheddar cheese, caramelized onions, house pickles, and secret burger sauce.",
            category = "Dinner",
            prepTimeMinutes = 20,
            servings = 2,
            ingredients = "350g ground chuck beef (80/20)\n2 brioche burger buns toasted\n4 slices sharp American or cheddar cheese\n1 small yellow onion caramelized\nPickle slices\n2 tbsp mayonnaise + 1 tbsp ketchup + 1 tsp mustard (special sauce)\nSalt and freshly ground black pepper",
            instructions = "1. Divide beef into 4 equal round balls without compacting them.\n2. Heat a cast-iron skillet on high heat until smoking hot.\n3. Place beef balls on skillet and firmly smash flat with a metal spatula; season generously.\n4. Sear for 2 minutes until deeply browned, flip, and immediately top with cheese.\n5. Stack double patties onto toasted brioche with sauce, pickles, and caramelized onions.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 16,
            title = "Golden Brioche French Toast",
            description = "Thick slices of buttery brioche bread soaked in vanilla-cinnamon custard, cooked golden brown and served with maple syrup.",
            category = "Breakfast",
            prepTimeMinutes = 15,
            servings = 3,
            ingredients = "6 thick slices brioche bread\n3 large eggs\n3/4 cup whole milk\n1/4 cup heavy cream\n1 tbsp brown sugar\n1 tsp pure vanilla extract\n1/2 tsp ground cinnamon\nButter for cooking\nPure maple syrup and fresh berries to serve",
            instructions = "1. Whisk eggs, milk, cream, sugar, vanilla, and cinnamon together in a shallow dish.\n2. Heat a non-stick griddle or skillet over medium heat and melt a knob of butter.\n3. Dip brioche slices into the egg custard for 15 seconds per side.\n4. Cook on the griddle for 3-4 minutes per side until puffed and golden brown.\n5. Dust with powdered sugar and serve warm with pure maple syrup.",
            isFavorite = true,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 17,
            title = "Vegetable Sushi Rolls (Maki)",
            description = "Seasoned sushi rice wrapped in toasted nori seaweed, filled with avocado, crisp cucumber, and pickled radish.",
            category = "Vegetarian",
            prepTimeMinutes = 35,
            servings = 4,
            ingredients = "2 cups sushi short-grain rice cooked\n3 tbsp rice vinegar + 1 tbsp sugar + 1/2 tsp salt\n4 sheets toasted nori seaweed\n1 ripe avocado sliced\n1 cucumber julienned\n1 carrot shredded\nSoy sauce, pickled ginger, and wasabi for serving",
            instructions = "1. Fold seasoned rice vinegar mixture into freshly cooked warm sushi rice; let cool.\n2. Place a nori sheet shiny-side down on a bamboo rolling mat.\n3. Spread an even layer of rice over nori, leaving a 1-inch border at the top.\n4. Arrange avocado, cucumber, and carrot strips across the center.\n5. Roll tightly using the mat, moisten the edge with water to seal, and slice into 8 pieces.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 18,
            title = "Molten Chocolate Lava Cake",
            description = "Decadent individual chocolate cakes with firm outer cake layers and a warm, flowing molten chocolate center.",
            category = "Dessert",
            prepTimeMinutes = 25,
            servings = 4,
            ingredients = "120g bittersweet dark chocolate (70%)\n1/2 cup unsalted butter\n2 large eggs + 2 egg yolks\n1/3 cup granulated sugar\n2 tbsp all-purpose flour\nPinch of salt\nVanilla ice cream for serving",
            instructions = "1. Butter 4 ramekins and dust with cocoa powder; preheat oven to 220°C (425°F).\n2. Melt dark chocolate and butter together in a heatproof bowl set over simmering water.\n3. Whisk eggs, yolks, sugar, and salt in a bowl until pale and slightly frothy.\n4. Fold melted chocolate into egg mixture, then gently fold in flour.\n5. Divide batter into ramekins and bake for 12 minutes until sides are firm but center is soft.",
            isFavorite = true,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 19,
            title = "Valencia Seafood & Chicken Paella",
            description = "Traditional Spanish rice cooked in saffron broth with chicken, shrimp, calamari, green beans, and a caramelized bottom crust (socarrat).",
            category = "Lunch",
            prepTimeMinutes = 55,
            servings = 6,
            ingredients = "2 cups Bomba or short-grain paella rice\n300g chicken breast cut into pieces\n200g jumbo shrimp peeled\n150g calamari rings\n1 cup green beans trimmed\n4 cups hot chicken/seafood stock infused with saffron\n1 diced onion and 3 minced garlic cloves\n1 tsp smoked Spanish paprika\nLemon wedges to serve",
            instructions = "1. Heat olive oil in a wide paella pan; brown chicken pieces then set aside.\n2. In same oil, sauté onion, garlic, and green beans; stir in paprika and grated tomato.\n3. Add paella rice and stir to coat grains in aromatic sofrito.\n4. Pour in hot saffron stock and return chicken; cook over medium heat for 10 minutes without stirring.\n5. Arrange shrimp and calamari on top, reduce heat, and cook for 10 more minutes until socarrat forms.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 20,
            title = "Fresh Mango Mint Smoothie",
            description = "A refreshing tropical cooler blending ripe sweet mangoes, Greek yogurt, fresh mint leaves, honey, and crushed ice.",
            category = "Drinks",
            prepTimeMinutes = 5,
            servings = 2,
            ingredients = "2 ripe mangoes peeled and diced (or frozen mango chunks)\n1/2 cup plain Greek yogurt\n1/2 cup cold almond milk or whole milk\n6 fresh mint leaves\n1 tbsp raw honey or agave\n1/2 cup ice cubes",
            instructions = "1. Add mango chunks, Greek yogurt, milk, mint leaves, and honey into a blender.\n2. Add ice cubes and blend on high speed for 60 seconds until creamy and smooth.\n3. Taste and adjust sweetness with additional honey if desired.\n4. Pour into tall chilled glasses.\n5. Garnish with a sprig of fresh mint and a mango slice on the rim.",
            isFavorite = false,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 21,
            title = "Egyptian Karkadeh (Iced Hibiscus Tea)",
            description = "Egypt's beloved crimson infusion made from dried wild hibiscus flowers, sweetened and served over crushed ice.",
            category = "Drinks",
            prepTimeMinutes = 15,
            servings = 6,
            ingredients = "2 cups dried organic hibiscus calyces (karkadeh)\n6 cups cold water\n3/4 cup granulated sugar (adjust to taste)\n1 tbsp fresh lemon juice\nCrushed ice cubes\nFresh mint sprigs for serving",
            instructions = "1. Rinse dried hibiscus flowers briefly under cold running water to remove dust.\n2. Bring water to a boil in a pot, add hibiscus flowers, and remove from heat immediately.\n3. Cover and steep for at least 30 minutes (or overnight in the fridge for a deeper ruby color).\n4. Strain out the flowers, stir in sugar and lemon juice until completely dissolved.\n5. Chill thoroughly and serve over glasses filled with crushed ice.",
            isFavorite = true,
            sourceUrl = null
        ),
        RecipeEntity(
            id = 22,
            title = "Creamy Iced Caramel Macchiato",
            description = "Espresso poured over chilled whole milk with vanilla syrup, topped with rich homemade salted caramel drizzle.",
            category = "Drinks",
            prepTimeMinutes = 8,
            servings = 1,
            ingredients = "2 shots hot freshly brewed espresso\n3/4 cup cold whole milk or oat milk\n1.5 tbsp vanilla syrup\n1 tbsp thick caramel sauce\n1 cup ice cubes",
            instructions = "1. Pour vanilla syrup into the bottom of a tall glass.\n2. Fill glass 3/4 full with fresh ice cubes.\n3. Pour cold milk over the ice.\n4. Slowly pour hot espresso shots over the top so it creates dramatic layered tiers.\n5. Drizzle lavishly with salted caramel sauce and enjoy immediately with a straw.",
            isFavorite = false,
            sourceUrl = null
        )
    )
}
