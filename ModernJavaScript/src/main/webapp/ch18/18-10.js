function Ellipse(a, b) {
    this.a = a;  // 장축 방향 반지름
    this.b = b;  // 단축 방향 반지름
}
// 타원의 넓이를 계산하는 메서드
Ellipse.prototype.getArea = function() {
    return Math.PI*this.a*this.b;
};
// Object.prototype.toSting를 덮어쓴다
Ellipse.prototype.toString = function() {
    return "Ellipse " + this.a + " " + this.b;
};

function Circle(r) {
    // Ellipse 생성자를 빌려와서 프로퍼티를 정의합니다
    Ellipse.call(this, r, r);
    // 이곳에서 새로운 프로퍼티를 작성하거나, 기존의 프로퍼티를 덮어쓸 수 있음.
}

Circle.prototype = Object.create(Ellipse.prototype, {
    constructor: {
        configurable: true,
        enumerable: true,
        value: Circle,
        writable: true
    }
});
Circle.prototype.toString = function() {
    return "Circle " + this.a + " " + this.b;
};

var circle = new Circle(2);
console.log(circle.getArea());    // → 12.566370614359172
console.log(circle.toString());   // → Circle 2 2
