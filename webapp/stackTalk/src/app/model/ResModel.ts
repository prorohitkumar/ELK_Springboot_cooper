import { Choice } from "./Choice";
import { Usage } from "./Usage";

export class ResModel {
    id: string;
    object: string;
    created: number;
    model: string;
    choices: Choice[];
    usage: Usage;
    additionalProperties: any;
}