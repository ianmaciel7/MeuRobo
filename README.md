# MeuRobo
Repositório do robô criado para competição da Solutis Robot Arena

## Descrição do Robô

O T-90 é um tanque que trabalha procurando alvos próximos e executa movimento circular próximo ao alvo, atacando com diferentes cargas de munição a depender da distância do alvo

## Explicação do código

1. Pega dois maiores valores entre a largura e altura do campo de batalha
1. Enquanto o robô estiver vivo     
    * Irá movimentar para frente com valor máximo obtido da largura e altura do campo de batalha e tentará se movimentar de maneira circular
    * Irá rotacionar a arma em 360 graus em busca de alvos   
1. Se achar algum inimigo irá travar a mira no alvo
    * Dispara o canhão com determinada potência a depender da distância e energia ainda restante no robô 
1. Se bater em algum robo ele irá recuar ou seguir em frente para bater novamente no robô inimigo
1. Se for atingido por uma munição ele rotacionará 360 graus em busca do inimigo. Para executar é necessario que o penúltimo atacante seja diferente do atual
1. Se bater em alguma parede irá recuar ou irá mover para frente a depender da distância a frente do robô  


### Pontos fortes

trava em alvos

busca do robô inimigo que efetuou o disparo



### Pontos fracos

consome muita energia

ao executar a movimentação bate-se muito em paredes próximas 
