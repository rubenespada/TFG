En los roles en vez de tener un enum, tendré un boolean admin, si es verdadero el usuario será admin y si no será un usuario normal. Queda averiguar cómo añadir ese boolean al jwt.

PARA AÑADIR ROLES:
En la clase TokenUtils, el método createToken pide 2 parámetros, el de el email y el username, se puede ver como el username es aparte y se mete en un Map llamado extra. Hay que modificar esa parte para poner en el extra un boolean que diga si es admin o no. Ese método se llama desde la clase JWTAuthenticationFilter. 
