# Caching-data-spring-boot

To implement Cache in spring we need to configure Ehcache, in this case that cache type I implement Ehcache.

# Attention
I just sharing part of code configure LDAP, please kindly more explore for the other source what you need.

# Explanation
Include your dependencies for this case we need include dependencies for Ehcache.
You can configure cache with XML or Bean Configuration
To enable cache, in the service just put annotation @Cacehenable and you can customize key, value and condition
Don't forget to create cache name with @Cacheconfigure
