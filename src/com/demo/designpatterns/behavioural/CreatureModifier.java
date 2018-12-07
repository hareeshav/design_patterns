package com.demo.designpatterns.behavioural;


public class CreatureModifier {
		
		protected Creature creature;
		protected CreatureModifier next;
		
		public CreatureModifier(Creature creature) {
			super();
			this.creature = creature;
		}
		
		public void add(CreatureModifier cm) {
			if(null == this.next) {
				this.next =cm;
			}else {
				this.next.add(cm);
			}
		}
		
		public void handle() {
			if(null != this.next) {
				this.next.handle();
			}
		}
}
