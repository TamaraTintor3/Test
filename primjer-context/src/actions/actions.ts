export enum ActionType {
  ON_CHANGE,
  CLEAR,
}

interface OnChange {
  type: ActionType.ON_CHANGE;
  payload: { name: string; age: number };
}

interface Clear {
  type: ActionType.CLEAR;
}

export type Actions = OnChange | Clear;
