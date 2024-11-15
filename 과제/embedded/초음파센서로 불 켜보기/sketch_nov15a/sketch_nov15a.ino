const int trigPIN = 1, echoPIN = 2;
const int redPIN = 4, greenPIN = 5, bluePIN = 6;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(trigPIN, OUTPUT);
  pinMode(echoPIN, INPUT);
  pinMode(redPIN, OUTPUT);
  pinMode(greenPIN, OUTPUT);
  pinMode(bluePIN, OUTPUT);
}

void loop() {
  float duration, distance;

  digitalWrite(trig, LOW);  
  delayMicroseconds(5);     // trig 핀 초기화
  digitalWrite(trig, HIGH); 
  delayMicroseconds(10);  
  digitalWrite(trig, LOW);

  duration = pulseIn(echo, HIGH); // 초음파 신호 수신 대기,echo 핀에서 HIGH 신호의 지속 시간 측정

  // 거리 계산
  distance = duration * 0.034 / 2;

  Serial.print("Distance: ");
  Serial.print(distance);
  Serial.println(" cm");

  if (distance <= 10) {
    digitalWrite(blue, LOW);
    digitalWrite(green, LOW);
    digitalWrite(red, HIGH);
  }
  else if (distance <= 20) {
    digitalWrite(blue, LOW);
    digitalWrite(green, HIGH);
    digitalWrite(red, LOW);
  }
  else {
    digitalWrite(blue, HIGH);
    digitalWrite(green, LOW);
    digitalWrite(red, LOW);
  }

  delay(200);
}