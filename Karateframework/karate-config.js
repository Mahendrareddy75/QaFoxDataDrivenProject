function fn() {   
  var env = karate.env;
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev'; 
  }
  var config = { 
    envURL: 'http://dummy.restapiexample.com'
  };
  if (env == 'stage') {
    config.envURL = 'https://stage-host/v1/auth';
  } else if (env == 'test') {
    config.envURL = 'http://dummy.restapiexample.com';
  }
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  return config;
}